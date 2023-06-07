package ru.ecom.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ecom.ecommerce.model.Basket;
import ru.ecom.ecommerce.model.Product;

@Setter
@Getter
@NoArgsConstructor
public class BasketDetailDTO {

    private long id;
    private Basket basket;
    private Product product;
    private int quantity;
    private long productPrice;

}
