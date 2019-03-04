package myfiche.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class File {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@NotNull
	@NotEmpty
	@Length(max = 64)
	private String name;
	@ManyToOne
	private Catalog parent;
	@NotNull
	@NotEmpty
	@Column(updatable = false, insertable = false)
	private String type;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Catalog getParent() {
		return parent;
	}
	public void setParent(Catalog parent) {
		this.parent = parent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
