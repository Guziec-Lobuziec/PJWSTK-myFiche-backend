package myfiche.dto;

public class FicheDataDTO {
	
	private Long id = new Long(0);
	private Integer version = new Integer(0);
	private String frontText = "";
	private String backText = "";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getFrontText() {
		return frontText;
	}
	public void setFrontText(String frontText) {
		this.frontText = frontText;
	}
	public String getBackText() {
		return backText;
	}
	public void setBackText(String backText) {
		this.backText = backText;
	}
	
	
	
}
