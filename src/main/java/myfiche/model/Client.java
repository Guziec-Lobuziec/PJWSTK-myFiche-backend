package myfiche.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client extends User {
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Catalog userRootCatalog;
	@OneToMany(cascade =  CascadeType.ALL)
	@JsonManagedReference
	private List<BoughtFicheSchema> boughtFicheSchema;
}
