package ru.ecom.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ecom.ecommerce.dto.OrderDTO;
import ru.ecom.ecommerce.dto.OrderDetailDTO;
import ru.ecom.ecommerce.service.ClientService;
import ru.ecom.ecommerce.service.OrderDetailService;
import ru.ecom.ecommerce.service.OrderService;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final ClientService clientService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderDetailService orderDetailService,
                           ClientService clientService) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.clientService = clientService;
    }


    @GetMapping("/orders")
    public String getAllOrders(Model model){
        List<OrderDTO> orderDTOList = orderService.getAllOrdersDtoByClientId(clientService.getCurrentClientDtoId());
        model.addAttribute("ordersList", orderDTOList);
        return "order_list";
    }

    @GetMapping("/orders/details")
    public String getOrderDetails(Model model){
        OrderDTO orderDTO = orderService.getOrderDtoByClientId(clientService.getCurrentClientDtoId());
        if (orderDTO != null) {
            List<OrderDetailDTO> orderDetailDTOList = orderDetailService.getOrderDetailListByOrderId(orderDTO.getId());
            model.addAttribute("orderDetailsList", orderDetailDTOList);
            model.addAttribute("totalPrice", orderDetailService.getSumByOrderId(orderDTO.getId()));
            model.addAttribute("order", orderDTO);
        }
        return "order_details";
    }
}
