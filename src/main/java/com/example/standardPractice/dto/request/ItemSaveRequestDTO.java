package com.example.standardPractice.dto.request;

import com.example.standardPractice.entity.enums.MeasuringUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String itemName;
    private MeasuringUnit measuringUnitType;
    private double balanceQTY;
    private double supplierPrice;
    private double sellingPrice;


}
