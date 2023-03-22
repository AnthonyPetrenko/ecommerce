package ru.ecom.ecommerce.dto;

import ru.ecom.ecommerce.model.BasketDetail;

import java.util.List;

public class BasketDTO {

    private long id;
    private List<BasketDetail> basketDetailList;

    public BasketDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<BasketDetail> getBasketDetailList() {
        return basketDetailList;
    }

    public void setBasketDetailList(List<BasketDetail> basketDetailList) {
        this.basketDetailList = basketDetailList;
    }
}
