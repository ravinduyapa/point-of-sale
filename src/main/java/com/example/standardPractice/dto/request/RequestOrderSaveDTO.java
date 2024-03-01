package com.example.standardPractice.dto.request;

import com.example.standardPractice.entity.Customer;
import com.example.standardPractice.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSave> orderDetails;


}


