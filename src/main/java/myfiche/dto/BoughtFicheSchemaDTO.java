package myfiche.dto;

import java.time.LocalDateTime;

import myfiche.model.FicheSchema;

public class BoughtFicheSchemaDTO {
	
	private Long id = new Long(0);
	private Integer version = new Integer(0);
	private FicheSchema ficheSchema;
	private LocalDateTime dateBought = LocalDateTime.now();
	
}
