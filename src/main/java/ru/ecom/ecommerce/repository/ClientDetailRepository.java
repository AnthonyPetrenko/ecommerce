package ru.ecom.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ecom.ecommerce.model.Client;

public interface ClientDetailRepository extends JpaRepository<Client, Long> {

    Client findByUsername(String username);

}
