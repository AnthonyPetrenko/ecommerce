package ru.ecom.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ecom.ecommerce.dto.BasketDetailDTO;
import ru.ecom.ecommerce.model.BasketDetail;

@Mapper
public interface BasketDetailMapper {

    BasketDetailMapper INSTANCE = Mappers.getMapper(BasketDetailMapper.class);

    BasketDetail toBasketDetail(BasketDetailDTO basketDetailDTO);

    BasketDetailDTO toDto(BasketDetail basketDetail);

}
