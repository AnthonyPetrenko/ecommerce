package ru.ecom.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ecom.ecommerce.dto.ProductDTO;
import ru.ecom.ecommerce.model.Product;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDTO productDTO);

    ProductDTO toDto(Product product);

}
