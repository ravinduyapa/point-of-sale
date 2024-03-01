package com.example.standardPractice.service;

import com.example.standardPractice.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int customerID);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomerByID(int customerID);
}
