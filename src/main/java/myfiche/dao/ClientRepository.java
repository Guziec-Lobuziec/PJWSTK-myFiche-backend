package myfiche.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import myfiche.model.Client;

public interface ClientRepository extends UserBaseRepository<Client> {
	
	
	@Query("select c from Client c where c.nick = :nick")
	Optional<Client> findByNick(@Param("nick") String nick);
	
}
