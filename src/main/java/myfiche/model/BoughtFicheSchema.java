package myfiche.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class BoughtFicheSchema {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@NotNull
	@ManyToOne
	private Client client;
	@NotNull
	@ManyToOne
	private FicheSchema ficheSchema;
	@NotNull
	private LocalDateTime dateBought;

}
