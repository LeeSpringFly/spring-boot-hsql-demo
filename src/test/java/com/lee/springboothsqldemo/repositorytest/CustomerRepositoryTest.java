package com.lee.springboothsqldemo.repositorytest;


import com.lee.springboothsqldemo.pojo.Customer;
import com.lee.springboothsqldemo.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        customerRepository.save(Customer.builder().name("John").email("john@domain.com").build());
        assertThat(customerRepository.findById(1L)).isInstanceOf(Optional.class);
        System.out.println(customerRepository.findById(1L).get());
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        customerRepository.save(Customer.builder().name("John").email("john@domain.com").build());
        customerRepository.save(Customer.builder().name("Julie").email("julie@domain.com").build());
        customerRepository.findAll().stream().forEach(System.out::println);
        assertThat(customerRepository.findAll()).isInstanceOf(List.class);
    }
}
