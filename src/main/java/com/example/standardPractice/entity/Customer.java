package com.example.standardPractice.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer_id",length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",length = 255)
    private String customerName;

    @Column(name = "customer_Address",length = 255)
    private String customerAddress;

    @Column(name = "customer_Salary",length = 30)
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_number",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "customer_NIC",length = 20)
    private String customerNIC;

    @Column(name = "active_state",columnDefinition ="TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy="customer")
   private Set<Order> orders;






}
