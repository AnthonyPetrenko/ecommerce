package ru.ecom.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ecom.ecommerce.dto.OrderDetailDTO;
import ru.ecom.ecommerce.model.OrderDetail;

@Mapper
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetail toOrderDetail (OrderDetailDTO orderDetailDTO);

    OrderDetailDTO toDto (OrderDetail orderDetail);

}
