package ru.ecom.ecommerce.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ecom.ecommerce.dto.ClientDto;

import java.util.Collection;

public class ClientDetails implements UserDetails {

    private final ClientDto clientDto;

    public ClientDetails(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.clientDto.getPassword();
    }

    @Override
    public String getUsername() {
        return this.clientDto.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public ClientDto getClientDto(){
        return this.clientDto;
    }

    public long getClientDtoId(){
        return getClientDto().getId();
    }
}
