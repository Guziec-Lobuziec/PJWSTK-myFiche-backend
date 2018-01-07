package myfiche.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Catalog extends File {
	
	@OneToMany
	@JsonManagedReference
	private List<File> files;
	
}
