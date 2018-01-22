package myfiche.dto;

import java.util.List;

public class FicheDTO extends FileDTO  {
	
	private boolean twoSided;
	private List<FicheDataDTO> ficheData;
	private BoughtFicheSchemaDTO usedSchema;
	
	public boolean isTwoSided() {
		return twoSided;
	}
	public void setTwoSided(boolean twoSided) {
		this.twoSided = twoSided;
	}
	public List<FicheDataDTO> getFicheData() {
		return ficheData;
	}
	public void setFicheData(List<FicheDataDTO> ficheData) {
		this.ficheData = ficheData;
	}
	public BoughtFicheSchemaDTO getUsedSchema() {
		return usedSchema;
	}
	public void setUsedSchema(BoughtFicheSchemaDTO usedSchema) {
		this.usedSchema = usedSchema;
	}
	
	
	
}
