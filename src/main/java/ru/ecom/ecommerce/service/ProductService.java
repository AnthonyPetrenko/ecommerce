package ru.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ecom.ecommerce.dto.ProductDTO;
import ru.ecom.ecommerce.mapper.ProductMapper;
import ru.ecom.ecommerce.model.Product;
import ru.ecom.ecommerce.repository.ProductRepository;
import java.util.List;

@Repository
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public ProductDTO getProductById(long id){
        Product product = productRepository.findById(id).orElse(null);
        return ProductMapper.INSTANCE.toDto(product);
    }

    public void addNewProduct(ProductDTO productDTO){
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        productRepository.save(product);
    }

    public void deleteProductByName(String name){
        productRepository.deleteProductByName(name);
    }
}
