package com.jsonar.sample.repositories;

import com.jsonar.sample.models.OrderDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
    @Query(value = "SELECT ot FROM OrderDetail ot WHERE ot.order.orderNumber = :orderNumber")
    List<OrderDetail> findByOrderNumber(Integer orderNumber);
}
