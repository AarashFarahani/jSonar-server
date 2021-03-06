package com.jsonar.sample.repositories;

import com.jsonar.sample.models.order.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT o FROM Order o " +
            "WHERE o.customer.customerNumber = :customerNumber " +
            "order by o.orderDate")
    List<Order> findByCustomerNumber(Integer customerNumber);
}
