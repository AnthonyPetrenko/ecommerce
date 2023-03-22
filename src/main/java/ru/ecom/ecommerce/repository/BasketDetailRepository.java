package ru.ecom.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ecom.ecommerce.model.BasketDetail;

import javax.transaction.Transactional;
import java.util.List;

public interface BasketDetailRepository extends JpaRepository<BasketDetail, Long> {

    List<BasketDetail> findBasketDetailsByBasketId(long basketId);

    @Transactional
    void deleteBasketDetailById(long basketDetailId);

    @Transactional
    void deleteBasketDetailsByBasketId(long basketId);

}
