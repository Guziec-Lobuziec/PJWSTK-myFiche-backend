package myfiche.model;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance
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
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	private Catalog parent;
	
}
