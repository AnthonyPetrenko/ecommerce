package ru.ecom.ecommerce.dto;

import ru.ecom.ecommerce.model.Basket;
import ru.ecom.ecommerce.model.Order;

import java.util.List;

public class ClientDto {

    private long id;
    private String username;
    private String password;
    private String email;
    private Basket basket;
    private List<Order> orderList;

    public ClientDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
