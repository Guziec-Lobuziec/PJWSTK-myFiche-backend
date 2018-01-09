package myfiche.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Fiche extends File {
	
	@NotNull
	private boolean twoSided;
	@OneToMany
	private List<FicheData> ficheData;
	@ManyToOne
	private BoughtFicheSchema usedSchema;
	
}
