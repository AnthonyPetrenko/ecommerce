package ru.ecom.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ecom.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductByName(String name);

}
