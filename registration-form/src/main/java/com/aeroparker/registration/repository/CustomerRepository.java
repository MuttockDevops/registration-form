package com.aeroparker.registration.repository;

import com.aeroparker.registration.model.Customer;  // <-- this is the missing import
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmailAddressIgnoreCase(String emailAddress);
}
