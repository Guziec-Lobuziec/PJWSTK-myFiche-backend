package myfiche.restful;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import myfiche.dao.ClientRepository;
import myfiche.dto.CatalogDTO;
import myfiche.dto.FicheDTO;
import myfiche.model.Catalog;
import myfiche.model.File;

@RestController
public class UserController {

	@Autowired
	private ClientRepository clientRepo;
	
	@RequestMapping(path= "/{nick}/**", method = RequestMethod.GET)
	public Object getFileWithPath(@PathVariable("nick") String nick, HttpServletRequest request) {
	    
		String restOfTheUrl = (String)
		        request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE); 
	    
		System.out.println(restOfTheUrl);
		System.out.println(nick);
		
	    Optional<File> file =  clientRepo.findByNick(nick).map(c -> c.getUserRootCatalog());
	    List<String> path = Arrays.asList(restOfTheUrl.split("\\/"));
	    path = path.subList(2, path.size());
	    
	    System.out.println(file.map(f->f.getName()).orElse(""));
	    System.out.println(Catalog.class.getSimpleName());
	    System.out.println(path);
	    
	    if(!path.isEmpty()){
	    		
	    		for(String part : path) {
	    			System.out.println(part);
	    			file = file.map(f -> {
		    				if(f.getType().compareTo(Catalog.class.getSimpleName()) == 0)
		    					return (Catalog) f;
		    				else
		    					return null;})
	    				.flatMap(c -> 
		    				c.getFiles().stream()
		    					.filter(f -> {return f.getName().compareTo(part)==0;})
		    					.findFirst());
	    			System.out.println(file.map(f->f.getName()).orElse(""));
	    		}
	    		
	    		
	    }
	    
	    
	    return file.map(f -> {
			if(f.getType().compareTo(Catalog.class.getSimpleName()) == 0)
				return new ModelMapper().map(f, CatalogDTO.class);
			else
				return new ModelMapper().map(f, FicheDTO.class);})
	    	.map(f -> (Object) f)
	    	.orElse(new ResponseEntity<String>(HttpStatus.NOT_FOUND));
	    
	}
	
}
