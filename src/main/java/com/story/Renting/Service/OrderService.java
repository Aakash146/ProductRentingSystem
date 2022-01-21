package com.story.Renting.Service;

import com.story.Renting.DTO.OrderDTO;
import com.story.Renting.DTO.OrderDetailDTO;
import com.story.Renting.Entity.Book;
import com.story.Renting.Entity.Movie;
import com.story.Renting.Entity.Order;
import com.story.Renting.Enum.BookStatus;
import com.story.Renting.Enum.MovieStatus;
import com.story.Renting.Enum.RentStatus;
import com.story.Renting.Repository.BookRepository;
import com.story.Renting.Repository.CustomerRepository;
import com.story.Renting.Repository.MovieRepository;
import com.story.Renting.Repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService implements IOrderService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<OrderDetailDTO> getAllOrderDetails(Long custId) {
        boolean exists = orderRepository.existsById(custId);
        if(!exists){
            LOGGER.error("Customer with customer_id: '"+ custId + "' don't exists.");
            throw new IllegalStateException("Customer with customer_id: '"+ custId + "' don't exists.");
        }
        final List<Order> orders = orderRepository.findByCustomer(custId);
        final List<OrderDetailDTO> dtos = new ArrayList<>();
        orders.forEach(order -> {
            final OrderDetailDTO dto = new OrderDetailDTO();
            dto.setProductType(order.getProductType());
            dto.setProductName(order.getProductName());
            dto.setOrderDate(order.getOrderDate());
            dto.setDays(order.getDays());
            dto.setReturnDate(order.getReturnDate());
            dto.setOrderAmount(order.getOrderAmount());
            dto.setFine(order.getFine());
            dto.setTotalAmount(order.getTotalAmount());
            dto.setCustId(order.getCustomer().getCustId());
            dto.setRentStatus(order.getRentStatus());
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    @Transactional
    public Order addNewOrder(OrderDTO orderDTO) {
        final List<Order> orders = orderRepository.findByCustomer(orderDTO.getCustId());
        final LocalDate returnDate =orderDTO.getOrderDate().plusDays(orderDTO.getDays());
        final Order newOrder = new Order();
        if(orders.isEmpty()){
            if(orderDTO.getProductType().equalsIgnoreCase("Movie")){
                final Movie movie = movieRepository.findBymovieName(orderDTO.getProductName());
                if(Objects.isNull(movie)){
                    LOGGER.error("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is not available in movie section.");
                    throw new IllegalStateException("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is not available in movie section.");
                }
                if(movie.getStatus().equals(MovieStatus.ON_RENT)){
                    LOGGER.error("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                    throw new IllegalStateException("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                }
                addOrder(newOrder, orderDTO);
                orderRepository.save(newOrder);
                LOGGER.info("New Order created succesfully with details {}", newOrder.toString());
            }
            else if(orderDTO.getProductType().equalsIgnoreCase("Book")){
                final Book book = bookRepository.findBybookName(orderDTO.getProductName());
                if(Objects.isNull(book)){
                    LOGGER.error("Book with book_Name: '" + orderDTO.getProductName() + "' is not available in book section.");
                    throw new IllegalStateException("Book with book_Name: '" + orderDTO.getProductName() + "' is not available in book section.");
                }
                if(book.getStatus().equals(MovieStatus.ON_RENT)){
                    LOGGER.error("Book with Book_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                    throw new IllegalStateException("Book with Book_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                }
                addOrder(newOrder, orderDTO);
                orderRepository.save(newOrder);
                LOGGER.info("New Order created succesfully with details {}", newOrder.toString());
            }
            else{
                LOGGER.error("Invalid Product Type.");
                throw new IllegalStateException("Invalid Product Type.");
            }
        }
        else{
            for(Order lastOrder : orders){
                if (returnDate.isBefore(lastOrder.getOrderDate()) || orderDTO.getOrderDate().isAfter(lastOrder.getReturnDate()) || lastOrder.getRentStatus() == RentStatus.RETURNED) {
                    if (orderDTO.getProductType().equalsIgnoreCase("Movie")) {
                        final Movie movie = movieRepository.findBymovieName(orderDTO.getProductName());
                        if (Objects.isNull(movie)) {
                            LOGGER.error("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is not available in movie section.");
                            throw new IllegalStateException("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is not available in movie section.");
                        }
                        if (movie.getStatus().equals(MovieStatus.ON_RENT)) {
                            LOGGER.error("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                            throw new IllegalStateException("Movie with Movie_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                        }
                        addOrder(newOrder, orderDTO);
                        orderRepository.save(newOrder);
                        LOGGER.info("New Order created succesfully with details {}", newOrder.toString());
                    } else if (orderDTO.getProductType().equalsIgnoreCase("Book")) {
                        final Book book = bookRepository.findBybookName(orderDTO.getProductName());
                        if (Objects.isNull(book)) {
                            LOGGER.error("Book with book_Name: '" + orderDTO.getProductName() + "' is not available in book section.");
                            throw new IllegalStateException("Book with book_Name: '" + orderDTO.getProductName() + "' is not available in book section.");
                        }
                        if (book.getStatus().equals(MovieStatus.ON_RENT)) {
                            LOGGER.error("Book with Book_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                            throw new IllegalStateException("Book with Book_Name: '" + orderDTO.getProductName() + "' is already on rent.");
                        }
                        addOrder(newOrder, orderDTO);
                        orderRepository.save(newOrder);
                        LOGGER.info("New Order created succesfully with details {}", newOrder.toString());
                    } else {
                        LOGGER.error("Invalid Product Type.");
                        throw new IllegalStateException("Invalid Product Type.");
                    }
                }
                else{
                    LOGGER.error("Request Order overlaps with existing order.");
                    throw new IllegalStateException("Request Order overlaps with existing order.");
                }
            }
        }
        return newOrder;
    }

    public Order addOrder(Order newOrder, OrderDTO orderDTO){
        newOrder.setProductType(orderDTO.getProductType());
        newOrder.setProductName(orderDTO.getProductName());
        newOrder.setOrderDate(orderDTO.getOrderDate());
        newOrder.setDays(orderDTO.getDays());
        newOrder.setReturnDate(orderDTO.getOrderDate().plusDays(orderDTO.getDays()));
        if(orderDTO.getProductType().equalsIgnoreCase("Movie")){
            final Movie movie = movieRepository.findBymovieName(orderDTO.getProductName());
            newOrder.setOrderAmount(orderDTO.getDays() * movie.getPricePerDay());
            movie.setStatus(MovieStatus.ON_RENT);
            movieRepository.save(movie);
        }
        else{
            final Book book = bookRepository.findBybookName(orderDTO.getProductName());
            newOrder.setOrderAmount(orderDTO.getDays() * book.getPricePerDay());
            book.setStatus(BookStatus.ON_RENT);
            bookRepository.save(book);
        }
        newOrder.setFine(0);
        newOrder.setTotalAmount(newOrder.getOrderAmount() + newOrder.getFine());
        newOrder.setCustomer(customerRepository.findByCustId(orderDTO.getCustId()));
        newOrder.setRentStatus(RentStatus.REQUESTED);
        return newOrder;
    }

    @Override
    @Transactional
    public Order returnProduct(Long orderId) {
        final Order order = orderRepository.findByorderId(orderId);
        if(Objects.isNull(order)){
            LOGGER.error("Order with order_id: " + orderId + " does not exist.");
            throw new IllegalStateException("Order with order_id: " + orderId + " does not exist.");
        }
        if(order.getRentStatus().equals(RentStatus.RETURNED) || order.getRentStatus().equals(RentStatus.RETURNED_WITH_FINE)){
            LOGGER.error("Order with order_id: " + orderId + " is already " + order.getRentStatus() + ".");
        }
        if(order.getRentStatus().equals(RentStatus.RENTING)){
            order.setRentStatus(RentStatus.RETURNED);
        }
        else if(order.getRentStatus().equals(RentStatus.DELAYED)){
            order.setRentStatus(RentStatus.RETURNED_WITH_FINE);
        }
        orderRepository.save(order);
        LOGGER.info("Order with order_id: " + orderId + " successfully " + order.getRentStatus() + ".");
        return order;
    }

    @Override
    @Transactional
    public Order cancelOrder(Long orderId) {
        final Order order = orderRepository.findByorderId(orderId);
        if(Objects.isNull(order)){
            LOGGER.error("Order with order_id: " + orderId + " does not exist.");
            throw new IllegalStateException("Order with order_id: " + orderId + " does not exist.");
        }
        if(order.getRentStatus().equals(RentStatus.REQUESTED)){
            order.setRentStatus(RentStatus.CANCELLED);
            orderRepository.save(order);
            LOGGER.info("Order with order_id: " + orderId + " successfully " + order.getRentStatus() + ".");
        }
        else{
            LOGGER.error("Order with order_id: " + orderId + " cannot be cancelled.");
            throw new IllegalStateException("Order with order_id: " + orderId + " cannot be cancelled.");
        }
        return order;
    }
}
