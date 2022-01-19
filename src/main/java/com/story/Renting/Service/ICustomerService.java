package com.story.Renting.Service;

import com.story.Renting.DTO.CustomerDTO;
import com.story.Renting.DTO.CustomerDetailDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDetailDTO> getAllCustomersDetail();

    String registerNewCustomer(CustomerDTO customerDTO);

    String deleteCustomer(Long custId);
}
