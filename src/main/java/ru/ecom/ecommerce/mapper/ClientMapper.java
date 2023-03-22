package ru.ecom.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ecom.ecommerce.dto.ClientDto;
import ru.ecom.ecommerce.model.Client;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient (ClientDto clientDto);

    ClientDto toClientDto (Client client);

}
