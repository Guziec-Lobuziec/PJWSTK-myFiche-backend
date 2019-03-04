package myfiche.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import myfiche.model.FicheSchema;

public interface FicheSchemaRepository extends PagingAndSortingRepository<FicheSchema, Long> {

}
