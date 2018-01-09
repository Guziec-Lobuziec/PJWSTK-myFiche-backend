package myfiche.restful;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.ExposesResourceFor;

import myfiche.model.File;

@ExposesResourceFor(File.class)
@RepositoryRestResource(collectionResourceRel = "files", path = "files")
public interface FileRepository extends FileBaseRepository<File> {

}
