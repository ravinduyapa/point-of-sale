package com.example.standardPractice.entity;

import com.example.standardPractice.entity.enums.MeasuringUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "item_id", length = 45, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemID;

    @Column(name = "item_name", length = 255, nullable = false)
    private String itemName;

    @Column(name = "measure_type", length = 255, nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasuringUnit measuringUnitType;

    @Column(name = "balance_qty", length = 255, nullable = false)
    private double balanceQTY;

    @Column(name = "supplier_price", length = 255, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 255, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;

  @OneToMany(mappedBy="items")
  private Set<OrderDetails> orderDetails ;


}


