package myfiche.restful;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import myfiche.model.File;

@NoRepositoryBean
public interface FileBaseRepository<T extends File> extends PagingAndSortingRepository<T, Long> {

}
