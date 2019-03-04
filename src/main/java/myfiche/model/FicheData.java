package myfiche.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class FicheData {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@ManyToOne
	private Fiche fiche;
	private String frontText;
	private String backText;
	
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
	public Fiche getFiche() {
		return fiche;
	}
	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
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
