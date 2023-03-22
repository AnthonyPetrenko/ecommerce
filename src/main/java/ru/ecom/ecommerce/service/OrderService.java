package ru.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.OrderDTO;
import ru.ecom.ecommerce.mapper.OrderMapper;
import ru.ecom.ecommerce.model.Order;
import ru.ecom.ecommerce.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientService clientService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientService clientService) {
        this.orderRepository = orderRepository;
        this.clientService = clientService;
    }

    public OrderDTO getOrderDtoByClientId(long clientId){
        Order order = orderRepository.getOrderByClientId(clientId);
        return OrderMapper.INSTANCE.toDto(order);
    }

    public List<OrderDTO> getAllOrdersDtoByClientId(long clientId){
        List<Order> orderList = orderRepository.getOrdersByClientId(clientId);
        return orderList.stream()
                .map(OrderMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public Order createAndGetNewOrder (long clientId) {
        Order order = new Order(clientService.findById(clientId));
        orderRepository.save(order);
        return order;
    }
}
