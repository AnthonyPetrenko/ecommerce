package ru.ecom.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "basket_detail")
@Setter
@Getter
@NoArgsConstructor
public class BasketDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_price")
    private long productPrice;

    public BasketDetail(Basket basket, Product product, long productPrice, int quantity){
        this.basket = basket;
        this.product = product;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }
}