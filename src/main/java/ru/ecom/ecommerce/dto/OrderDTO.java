package ru.ecom.ecommerce.dto;

import ru.ecom.ecommerce.model.Client;
import ru.ecom.ecommerce.model.OrderDetail;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private long id;
    private Date date;
    private long totalCost;
    private Client client;
    private List<OrderDetail> orderDetail;

    public OrderDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
