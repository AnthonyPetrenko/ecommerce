package ru.ecom.ecommerce.dto;

import ru.ecom.ecommerce.model.Order;
import ru.ecom.ecommerce.model.Product;

public class OrderDetailDTO {

    private long id;
    private Order order;
    private Product product;
    private long productPrice;
    private int quantity;

    public OrderDetailDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
