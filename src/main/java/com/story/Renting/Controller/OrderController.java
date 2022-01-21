package com.story.Renting.Controller;

import com.story.Renting.DTO.OrderDTO;
import com.story.Renting.DTO.OrderDetailDTO;
import com.story.Renting.Entity.Order;
import com.story.Renting.Service.IBookService;
import com.story.Renting.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping(path ="{custId}")
    public List<OrderDetailDTO> getAllOrderDetails(@PathVariable("custId") Long custId){

        return orderService.getAllOrderDetails(custId);
    }

    @PostMapping
    public Order addNewOrder(@RequestBody OrderDTO orderDTO){

        return orderService.addNewOrder(orderDTO);
    }

    @PutMapping(path = "{canel/orderId}")
    public Order cancelOrder(@PathVariable("orderId") Long orderId){

        return  orderService.cancelOrder(orderId);
    }

    @PutMapping(path = "{return/orderId}")
    public Order returnProduct(@PathVariable("orderId") Long orderId){

        return orderService.returnProduct(orderId);
    }
}
