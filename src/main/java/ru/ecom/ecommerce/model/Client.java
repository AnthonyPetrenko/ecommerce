package ru.ecom.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "client")
@Setter
@Getter
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    @Email
    private String email;

    @OneToOne(mappedBy = "client")
    private Basket basket;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Order> orderList;
}