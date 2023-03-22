package ru.ecom.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ecom.ecommerce.dto.OrderDTO;
import ru.ecom.ecommerce.model.Order;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder (OrderDTO orderDTO);

    OrderDTO toDto (Order order);

}
