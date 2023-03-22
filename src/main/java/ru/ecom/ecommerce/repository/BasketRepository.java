package ru.ecom.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ecom.ecommerce.model.Basket;

import javax.transaction.Transactional;


public interface BasketRepository extends CrudRepository<Basket, Long> {

    Basket findBasketByClientId(long clientId);

    @Transactional
    void deleteBasketById(long basketId);

}