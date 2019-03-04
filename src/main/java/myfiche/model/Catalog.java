package myfiche.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Catalog extends File {
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="parent",
			fetch=FetchType.LAZY)
	private List<File> files;

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	
	
}
