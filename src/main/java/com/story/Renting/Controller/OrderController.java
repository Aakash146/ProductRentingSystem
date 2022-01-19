package com.story.Renting.Controller;

import com.story.Renting.Service.IBookService;
import com.story.Renting.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
}
