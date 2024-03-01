package com.example.standardPractice.service;

import com.example.standardPractice.dto.request.RequestOrderSaveDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
