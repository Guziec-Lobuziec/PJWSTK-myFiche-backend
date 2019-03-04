package myfiche.restful;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import myfiche.dao.ClientRepository;
import myfiche.dao.FileRepository;
import myfiche.dto.CatalogDTO;
import myfiche.dto.FicheDTO;
import myfiche.dto.FileDTO;
import myfiche.model.Catalog;
import myfiche.model.Fiche;
import myfiche.model.File;

@RestController
public class UserController {

	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private FileRepository fileRepo;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path= "/{nick}/**", method = RequestMethod.GET)
	public Object getFileWithPath(@PathVariable("nick") String nick, HttpServletRequest request) {
	    
		String restOfTheUrl = (String)
		        request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE); 

		Optional<File> file =  findFileWithPath(nick,restOfTheUrl);
	    
	    return file.map(f -> {
			if(f.getType().compareTo(Catalog.class.getSimpleName()) == 0)
				return new ModelMapper().map(f, CatalogDTO.class);
			else
				return new ModelMapper().map(f, FicheDTO.class);})
	    	.map(f -> (Object) f)
	    	.orElse(new ResponseEntity<String>(HttpStatus.NOT_FOUND));
	    
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path= "/{nick}/**", method = RequestMethod.POST)
	public ResponseEntity<String> postFileWithPath(
			@PathVariable("nick") String nick, 
			HttpServletRequest request, 
			@RequestBody FileDTO newFile) {
	    
		String restOfTheUrl = (String)
		        request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE); 

	    Optional<File> file =  findFileWithPath(nick,restOfTheUrl);
	    
	    Optional<Catalog> catalog = file.map(f -> {
			if(f.getType().compareTo(Catalog.class.getSimpleName()) == 0)
				return (Catalog) f;
			else
				return null;});
	    
	    if(!catalog.isPresent()) {
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }
	    
	    File mapped;
	    
	    if(newFile.getType().compareTo(Catalog.class.getSimpleName()) == 0) {
	    	mapped = new ModelMapper().map(newFile, Catalog.class);
	    }
	    else if(newFile.getType().compareTo(Fiche.class.getSimpleName()) == 0) {
	    	mapped = new ModelMapper().map(newFile, Fiche.class);
	    }
	    else {
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }
	    
	    mapped.setParent(catalog.get());
	    fileRepo.save(mapped);
	    
	    
	    
	    return new ResponseEntity<String>(HttpStatus.CREATED);
	    
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path= "/{nick}/**", method = RequestMethod.PUT)
	public ResponseEntity<String> updateFileWithPath(
			@PathVariable("nick") String nick, 
			HttpServletRequest request, 
			@RequestBody FileDTO newFile) {
	    
		String restOfTheUrl = (String)
		        request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE); 

	    Optional<File> file =  findFileWithPath(nick,restOfTheUrl);
	    
	    if(!file.isPresent()) {
	    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	    
	    File mapped;
	    
	    if(newFile.getType().compareTo(Catalog.class.getSimpleName()) == 0) {
	    	mapped = new ModelMapper().map(newFile, Catalog.class);
	    }
	    else if(newFile.getType().compareTo(Fiche.class.getSimpleName()) == 0) {
	    	mapped = new ModelMapper().map(newFile, Fiche.class);
	    }
	    else {
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }
	    
	    if(mapped.getType().compareTo(file.get().getType()) != 0) {
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    }
	    mapped.setParent(file.get().getParent());
	    mapped.setId(file.get().getId());
	    mapped.setVersion(file.get().getVersion());
	    
	    fileRepo.save(mapped);
	    
	    return new ResponseEntity<String>(HttpStatus.OK);
	    
	}
	
	private Optional<File> findFileWithPath(String usernick, String url) {
		
			Optional<File> file =  clientRepo.findByNick(usernick).map(c -> c.getUserRootCatalog());
		    List<String> path = Arrays.asList(url.split("\\/"));
		    path = path.subList(2, path.size());
		    
		    if(!path.isEmpty()){
	    		
	    		for(String part : path) {
	    			file = file.map(f -> {
		    				if(f.getType().compareTo(Catalog.class.getSimpleName()) == 0)
		    					return (Catalog) f;
		    				else
		    					return null;})
	    				.flatMap(c -> 
		    				c.getFiles().stream()
		    					.filter(f -> {return f.getName().compareTo(part)==0;})
		    					.findFirst());
	    		}
	    		
	    		
	    		
		    }
		    
		    return file;
		
	}
	
}
