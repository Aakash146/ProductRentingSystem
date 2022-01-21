package com.story.Renting.Repository;

import com.story.Renting.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Long custId);

    Order findByorderId(Long orderId);
}
