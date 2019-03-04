package myfiche.dto;

import java.util.ArrayList;
import java.util.List;

public class CatalogDTO extends FileDTO {
	
	private List<FileOverviewDTO> files = new ArrayList<>();

	public List<FileOverviewDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileOverviewDTO> files) {
		this.files = files;
	}
	
	
}
