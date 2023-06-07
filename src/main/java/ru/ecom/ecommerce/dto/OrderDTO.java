package ru.ecom.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ecom.ecommerce.model.Client;
import ru.ecom.ecommerce.model.OrderDetail;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderDTO {

    private long id;
    private Date date;
    private long totalCost;
    private Client client;
    private List<OrderDetail> orderDetail;

}
