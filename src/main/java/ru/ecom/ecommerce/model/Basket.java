package ru.ecom.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
@Setter
@Getter
@NoArgsConstructor
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

    public Basket(Client client) {
        this.client = client;
    }
}