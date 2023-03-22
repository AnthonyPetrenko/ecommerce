package ru.ecom.ecommerce.dto;

import ru.ecom.ecommerce.model.Basket;
import ru.ecom.ecommerce.model.Product;

public class BasketDetailDTO {

    private long id;
    private Basket basket;
    private Product product;
    private int quantity;
    private long productPrice;

    public BasketDetailDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }
}
