package com.story.Renting.Service;

import com.story.Renting.DTO.OrderDTO;
import com.story.Renting.DTO.OrderDetailDTO;
import com.story.Renting.Entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService {
    List<OrderDetailDTO> getAllOrderDetails(Long custId);

    Order addNewOrder(OrderDTO orderDTO);

    String returnProduct(Long orderId);

    String cancelOrder(Long orderId);
}
