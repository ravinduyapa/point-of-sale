package com.example.standardPractice.service.impl;

import com.example.standardPractice.dto.request.RequestOrderSaveDTO;
import com.example.standardPractice.dto.response.ItemGetResponseDTO;
import com.example.standardPractice.entity.Order;
import com.example.standardPractice.entity.OrderDetails;
import com.example.standardPractice.exception.DuplicateException;
import com.example.standardPractice.repo.CustomerRepo;
import com.example.standardPractice.repo.ItemRepo;
import com.example.standardPractice.repo.OrderDetailsRepo;
import com.example.standardPractice.repo.OrderRepo;
import com.example.standardPractice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        List<OrderDetails> orderDetailsList = modelMapper.map(requestOrderSaveDTO.getOrderDetails(),
                new TypeToken<List<OrderDetails>>() {}.getType());

        for (int i = 0; i < orderDetailsList.size(); i++) {
            orderDetailsList.get(i).setOrders(order);
            orderDetailsList.get(i).setItems(itemRepo.getReferenceById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
        }

        if (!orderDetailsList.isEmpty()) {
            orderDetailsRepo.saveAll(orderDetailsList);
            return "Saved Successfully";
        } else {
            throw new DuplicateException("Already Saved Item for This ID");
        }
    }
}
