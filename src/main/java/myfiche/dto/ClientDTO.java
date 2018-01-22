package myfiche.dto;

public class ClientDTO {
	
	private String nick;
	private CatalogDTO userRootCatalog;
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public CatalogDTO getUserRootCatalog() {
		return userRootCatalog;
	}
	public void setUserRootCatalog(CatalogDTO userRootCatalog) {
		this.userRootCatalog = userRootCatalog;
	}
	
	
	
}
