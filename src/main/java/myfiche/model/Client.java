package myfiche.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client extends User {
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Catalog userRootCatalog;
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "client",
			fetch=FetchType.LAZY)
	private List<BoughtFicheSchema> boughtFicheSchema;
	public Catalog getUserRootCatalog() {
		return userRootCatalog;
	}
	public void setUserRootCatalog(Catalog userRootCatalog) {
		this.userRootCatalog = userRootCatalog;
	}
	public List<BoughtFicheSchema> getBoughtFicheSchema() {
		return boughtFicheSchema;
	}
	public void setBoughtFicheSchema(List<BoughtFicheSchema> boughtFicheSchema) {
		this.boughtFicheSchema = boughtFicheSchema;
	}
	
	
	
}
