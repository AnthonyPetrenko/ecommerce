package ru.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.ClientDto;
import ru.ecom.ecommerce.mapper.ClientMapper;
import ru.ecom.ecommerce.repository.ClientDetailRepository;
import ru.ecom.ecommerce.security.ClientDetails;

@Service
public class ClientDetailService implements UserDetailsService {

    private final ClientDetailRepository clientDetailRepository;

    @Autowired
    public ClientDetailService(ClientDetailRepository clientDetailRepository) {
        this.clientDetailRepository = clientDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientDto clientDto = ClientMapper.INSTANCE.toClientDto(clientDetailRepository.findByUsername(username));
        return new ClientDetails(clientDto);
    }
}
