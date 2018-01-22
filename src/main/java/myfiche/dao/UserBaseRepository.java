package myfiche.dao;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import myfiche.model.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends PagingAndSortingRepository<T, Long> {
	
}
