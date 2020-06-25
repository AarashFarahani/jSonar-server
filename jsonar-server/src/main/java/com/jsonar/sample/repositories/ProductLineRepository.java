package com.jsonar.sample.repositories;

import com.jsonar.sample.models.ProductLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends CrudRepository<ProductLine, String> {
}
