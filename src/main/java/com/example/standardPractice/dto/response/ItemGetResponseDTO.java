package com.example.standardPractice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int itemID;
    private String itemName;
    private double balanceQTY;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
