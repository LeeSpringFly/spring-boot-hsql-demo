package com.lee.springboothsqldemo.repository;

import com.lee.springboothsqldemo.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
