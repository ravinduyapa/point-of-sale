package com.example.standardPractice.dto.request;

import com.example.standardPractice.entity.Item;
import com.example.standardPractice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {
    private String itemName;
    private double qty;
    private Double amount;
    private int items;
}
