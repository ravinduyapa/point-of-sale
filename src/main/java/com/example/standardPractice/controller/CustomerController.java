package com.example.standardPractice.controller;


import com.example.standardPractice.dto.CustomerDTO;
import com.example.standardPractice.service.CustomerService;
import com.example.standardPractice.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String message = customerService.saveCustomer(customerDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return response;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        String message = customerService.updateCustomer(customerDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", message), HttpStatus.ACCEPTED
        );
        return response;
    }

    @GetMapping(value = "/get-by-id",
            params = "id")

    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerID) {
        CustomerDTO getCustomerById = customerService.getCustomerById(customerID);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(202, "Check This", getCustomerById), HttpStatus.OK
        );
        return response;

    }

    @GetMapping(value = "/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> getAllCustomer = customerService.getAllCustomers();
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(203, "Check All", getAllCustomer), HttpStatus.OK
        );
        return response;

    }

    @DeleteMapping(value = "/delete-customer-by-id",
                   params = "id")
    public ResponseEntity<StandardResponse> deleteCustomerByID(@RequestParam(value = "id")int customerID) {
        String message = customerService.deleteCustomerByID(customerID);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Delete Success", message), HttpStatus.OK
        );
        return response;

    }


}
