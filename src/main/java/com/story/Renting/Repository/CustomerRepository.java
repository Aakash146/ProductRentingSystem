package com.story.Renting.Repository;

import com.story.Renting.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String Email);

    Customer findByFarmId(Long custId);
}
