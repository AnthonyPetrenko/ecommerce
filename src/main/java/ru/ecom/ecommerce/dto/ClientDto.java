package ru.ecom.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ecom.ecommerce.model.Basket;
import ru.ecom.ecommerce.model.Order;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ClientDto {

    private long id;
    private String username;
    private String password;
    private String email;
    private Basket basket;
    private List<Order> orderList;

}