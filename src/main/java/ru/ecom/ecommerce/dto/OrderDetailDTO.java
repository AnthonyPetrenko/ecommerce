package ru.ecom.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ecom.ecommerce.model.Order;
import ru.ecom.ecommerce.model.Product;

@Setter
@Getter
@NoArgsConstructor
public class OrderDetailDTO {

    private long id;
    private Order order;
    private Product product;
    private long productPrice;
    private int quantity;

}