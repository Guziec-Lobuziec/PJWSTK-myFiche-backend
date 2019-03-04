package myfiche.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@Column(unique = true, nullable = false)
	private String nick;
	private String email;
	private byte[] hashSalt;
	private byte[] passwordHash;
	private String hashType;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getHashSalt() {
		return hashSalt;
	}
	public void setHashSalt(byte[] hashSalt) {
		this.hashSalt = hashSalt;
	}
	public byte[] getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getHashType() {
		return hashType;
	}
	public void setHashType(String hashType) {
		this.hashType = hashType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
