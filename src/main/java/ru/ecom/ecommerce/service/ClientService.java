package ru.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.ClientDto;
import ru.ecom.ecommerce.exception.ClientNotFoundException;
import ru.ecom.ecommerce.mapper.ClientMapper;
import ru.ecom.ecommerce.model.Client;
import ru.ecom.ecommerce.repository.ClientRepository;
import ru.ecom.ecommerce.security.ClientDetails;

import javax.transaction.Transactional;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepository clientRepository,
                         PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Client findById(long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public long getCurrentClientDtoId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long clientId = ((ClientDetails) authentication.getPrincipal()).getClientDtoId();
        return clientId;
    }

    @Transactional
    public void registerNewClient(ClientDto clientDto){
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }
}
