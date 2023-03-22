package ru.ecom.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ecom.ecommerce.model.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> getOrderDetailsByOrderId(long orderId);

    @Query(value = "SELECT SUM (od.productPrice * od.quantity)" +
            "FROM OrderDetail od " +
            "WHERE od.order.id = :orderId")
    Long getSumByOrderId(@Param("orderId") long orderId);

}
