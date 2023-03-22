package ru.ecom.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ecom.ecommerce.dto.BasketDTO;
import ru.ecom.ecommerce.model.Basket;

@Mapper
public interface BasketMapper {

    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    Basket toBasket (BasketDTO basketDTO);

    BasketDTO toDto(Basket basket);

}
