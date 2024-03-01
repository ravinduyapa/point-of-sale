package com.example.standardPractice.controller;

import com.example.standardPractice.dto.request.ItemSaveRequestDTO;
import com.example.standardPractice.dto.request.RequestOrderSaveDTO;
import com.example.standardPractice.service.OrderService;
import com.example.standardPractice.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String id = orderService.addOrder(requestOrderSaveDTO);
       // System.out.println(requestOrderSaveDTO);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(102, "Success", 2), HttpStatus.CREATED
        );
        return response;
    }

}
