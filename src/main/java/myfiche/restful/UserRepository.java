package myfiche.restful;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import myfiche.model.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends UserBaseRepository<User> {

}
