package myfiche.dto;

import java.time.LocalDateTime;

import myfiche.model.FicheSchema;

public class BoughtFicheSchemaDTO {
	
	private Long id;
	private Integer version;
	private FicheSchema ficheSchema;
	private LocalDateTime dateBought;
	
}
