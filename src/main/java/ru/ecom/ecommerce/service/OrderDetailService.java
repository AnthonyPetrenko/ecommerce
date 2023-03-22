package ru.ecom.ecommerce.service;

import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.OrderDetailDTO;
import ru.ecom.ecommerce.mapper.OrderDetailMapper;
import ru.ecom.ecommerce.model.OrderDetail;
import ru.ecom.ecommerce.repository.OrderDetailRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public void saveAll(List<OrderDetail> orderDetailList){
        orderDetailRepository.saveAll(orderDetailList);
    }

    @Transactional
    public long getSumByOrderId(long orderID){
        return orderDetailRepository.getSumByOrderId(orderID);
    }

    public List<OrderDetailDTO> getOrderDetailListByOrderId(long orderId) {
        List<OrderDetail> orderDetailsList = orderDetailRepository.getOrderDetailsByOrderId(orderId);
        return orderDetailsList.stream()
                .map(OrderDetailMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

}
