package com.example.standardPractice.service.impl;

import com.example.standardPractice.dto.CustomerDTO;
import com.example.standardPractice.entity.Customer;
import com.example.standardPractice.exception.DuplicateException;
import com.example.standardPractice.exception.NotFoundException;
import com.example.standardPractice.repo.CustomerRepo;
import com.example.standardPractice.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            throw new DuplicateException("Already Save Customer for This ID");
        } else {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return customerDTO.getCustomerId() + " Saved Successfully";
        }
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return customerDTO.getCustomerId() + " Update Successfully";
        } else {
            throw new NotFoundException("No Customer Found for This ID");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerID) {
        if (customerRepo.existsById(customerID)) {
            Customer customer = customerRepo.getReferenceById(customerID);
            return modelMapper.map(customer, CustomerDTO.class);
        } else {
            throw new NotFoundException("No Customer Found for This ID");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        if (customerList.size() > 0) {
            return modelMapper.map(customerList, new TypeToken<ArrayList<CustomerDTO>>() {
            }.getType());
        } else {
            throw new NotFoundException("No Customers Found");
        }
    }

    @Override
    public String deleteCustomerByID(int customerID) {
        if(customerRepo.existsById(customerID)){
            customerRepo.deleteById(customerID);
            return customerID+" Delete Successfully";
        }else{
            throw new NotFoundException("No Customers Found");
        }
    }

}
