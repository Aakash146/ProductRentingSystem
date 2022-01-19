package com.story.Renting.Service;

import com.story.Renting.DTO.CustomerDTO;
import com.story.Renting.DTO.CustomerDetailDTO;
import com.story.Renting.Entity.Customer;
import com.story.Renting.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements ICustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    @Transactional
    public String registerNewCustomer(CustomerDTO customerDTO){
        final Customer customer = customerRepository.findByEmail(customerDTO.getEmail());
        if(Objects.nonNull(customer)){
            LOGGER.error("Customer with email " + customerDTO.getEmail() + " already exists.");
            throw new IllegalStateException("Email already Exist");
        }
        final Customer newCustomer = new Customer();
        newCustomer.setFirstName(customerDTO.getFirstName());
        newCustomer.setLastName(customerDTO.getLastName());
        newCustomer.setEmail(customerDTO.getEmail());
        LOGGER.info("Customer with email " + customerDTO.getEmail() + " registered successfully.");
        customerRepository.save(newCustomer);
        return "Customer with email " + customerDTO.getEmail() + " registered successfully." ;
    }

    @Override
    @Transactional
    public String deleteCustomer(Long custId) {
        boolean exist = customerRepository.existsById(custId);
        if(!exist){
            LOGGER.info("Customer with id " + custId + "does not exist.");
            throw new IllegalStateException("Customer with id " + custId + "does not exist.");
        }
        customerRepository.deleteById(custId);
        return "Customer with id " + custId + " deleted successfully.";
    }

    @Override
    @Transactional
    public List<CustomerDetailDTO> getAllCustomersDetail() {
        final List<Customer> customers = customerRepository.findAll();
        final List<CustomerDetailDTO> dtos = new ArrayList<>();
        customers.forEach(customer -> {
            final CustomerDetailDTO dto = new CustomerDetailDTO();
            dto.setCustId(customer.getCustId());
            dto.setEmail(customer.getEmail());
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            dto.setFullName(customer.getFullName());
            dtos.add(dto);
        });
        return dtos;
    }
}
