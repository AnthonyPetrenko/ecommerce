package ru.ecom.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.ecom.ecommerce.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUsername(String username);

}
