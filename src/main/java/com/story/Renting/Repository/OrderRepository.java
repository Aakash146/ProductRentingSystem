package com.story.Renting.Repository;

import com.story.Renting.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.customer.custId = :custId")
    List<Order> findByCustomer(Long custId);

    Order findByorderId(Long orderId);
    @Query("select o from Order o where o.customer.custId = :custId")
    boolean existsByCustomer(Long custId);
}
