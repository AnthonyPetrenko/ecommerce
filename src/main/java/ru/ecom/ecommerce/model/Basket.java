package ru.ecom.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "id")
    private List<BasketDetail> basketDetailList;

    public Basket() {
    }

    public Basket(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<BasketDetail> getBasketDetailList() {
        return basketDetailList;
    }

    public void setBasketDetailList(List<BasketDetail> basketDetailList) {
        this.basketDetailList = basketDetailList;
    }
}
