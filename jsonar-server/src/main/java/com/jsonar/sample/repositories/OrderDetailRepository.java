package com.jsonar.sample.repositories;

import com.jsonar.sample.models.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
}
