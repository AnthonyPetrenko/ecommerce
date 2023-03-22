package ru.ecom.ecommerce.service;

import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.BasketDetailDTO;
import ru.ecom.ecommerce.model.Order;
import ru.ecom.ecommerce.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {

    private final BasketDetailService basketDetailService;
    private final BasketService basketService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;


    public TransferService(BasketDetailService basketDetailService,
                           BasketService basketService,
                           OrderService orderService,
                           OrderDetailService orderDetailService) {
        this.basketDetailService = basketDetailService;
        this.basketService = basketService;
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }

    public void transferBasketDetailsToOrderDetails(long basketId, long clientId) {
        Order order = orderService.createAndGetNewOrder(clientId);

        List<OrderDetail> listToAdd = transferDataFromBasketToOrder(basketId, order);

        orderDetailService.saveAll(listToAdd);
        order.setTotalCost(orderDetailService.getSumByOrderId(order.getId()));
        orderService.saveOrder(order);
        basketDetailService.deleteAllBasketDetailByBasketId(basketId);
        basketService.deleteBasketById(basketId);
    }

    private List<OrderDetail> transferDataFromBasketToOrder(long basketId, Order order){

        List<BasketDetailDTO> basketDetailsList = basketDetailService.getBasketDetailListByBasketId(basketId);
        List<OrderDetail> orderDetailsList = new ArrayList<>();

        for (BasketDetailDTO basketDetailDTO : basketDetailsList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(basketDetailDTO.getProduct());
            orderDetail.setProductPrice(basketDetailDTO.getProductPrice());
            orderDetail.setQuantity(basketDetailDTO.getQuantity());
            orderDetailsList.add(orderDetail);
        }

        return orderDetailsList;
    }
}
