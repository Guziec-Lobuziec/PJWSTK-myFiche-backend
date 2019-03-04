package myfiche.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Fiche extends File {
	
	@NotNull
	private boolean twoSided;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="fiche",
			fetch=FetchType.LAZY)
	private List<FicheData> ficheData;
	@ManyToOne(fetch=FetchType.LAZY)
	private BoughtFicheSchema usedSchema;
	
	public boolean isTwoSided() {
		return twoSided;
	}
	public void setTwoSided(boolean twoSided) {
		this.twoSided = twoSided;
	}
	public List<FicheData> getFicheData() {
		return ficheData;
	}
	public void setFicheData(List<FicheData> ficheData) {
		this.ficheData = ficheData;
	}
	public BoughtFicheSchema getUsedSchema() {
		return usedSchema;
	}
	public void setUsedSchema(BoughtFicheSchema usedSchema) {
		this.usedSchema = usedSchema;
	}
	
	
	
}
