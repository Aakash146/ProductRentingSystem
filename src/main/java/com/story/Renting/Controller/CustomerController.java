package com.story.Renting.Controller;

import com.story.Renting.DTO.CustomerDTO;
import com.story.Renting.DTO.CustomerDetailDTO;
import com.story.Renting.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public List<CustomerDetailDTO> getAllCustomersDetail(){

        return customerService.getAllCustomersDetail();
    }

    @PostMapping
    public String registerNewCustomer(@RequestBody CustomerDTO customerDTO){

        return customerService.registerNewCustomer(customerDTO);
    }

    @DeleteMapping(path = "{custId}")
    public String deleteCustomer(@PathVariable("custId") Long custId){

        return customerService.deleteCustomer(custId);
    }
}
