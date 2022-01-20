package com.story.Renting.Service;

import com.story.Renting.DTO.CustomerDTO;
import com.story.Renting.DTO.CustomerDetailDTO;
import com.story.Renting.Entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerDetailDTO> getAllCustomersDetail();

    Customer registerNewCustomer(CustomerDTO customerDTO);

    String deleteCustomer(Long custId);
}
