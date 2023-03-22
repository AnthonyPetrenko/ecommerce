package ru.ecom.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ecom.ecommerce.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order getOrderByClientId(long clientId);
    List<Order> getOrdersByClientId(long clientId);

}
