package myfiche.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Version;

@Entity
@Inheritance
public abstract class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	private String nick;
	private String email;
	private byte[] hashSalt;
	private byte[] passwordHash;
	private String hashType;
	
}
