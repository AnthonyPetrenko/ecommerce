package ru.ecom.ecommerce.service;

import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.BasketDetailDTO;
import ru.ecom.ecommerce.dto.ProductDTO;
import ru.ecom.ecommerce.mapper.BasketDetailMapper;
import ru.ecom.ecommerce.mapper.ProductMapper;
import ru.ecom.ecommerce.model.Basket;
import ru.ecom.ecommerce.model.BasketDetail;
import ru.ecom.ecommerce.model.Product;
import ru.ecom.ecommerce.repository.BasketDetailRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketDetailService {

    private final BasketDetailRepository basketDetailRepository;
    private final ProductService productService;


    public BasketDetailService(BasketDetailRepository basketDetailRepository, ProductService productService) {
        this.basketDetailRepository = basketDetailRepository;
        this.productService = productService;
    }

    public List<BasketDetailDTO> getBasketDetailListByBasketId(long basketId){
        List<BasketDetail> basketDetails = basketDetailRepository.findBasketDetailsByBasketId(basketId);
        return basketDetails
                .stream()
                .map(BasketDetailMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public long getBasketDetailPriceSum(List<BasketDetailDTO> basketDetailDTOList){
        return basketDetailDTOList
                .stream()
                .mapToLong(basketDetail -> basketDetail.getProductPrice() * basketDetail.getQuantity())
                .sum();
    }

    public void addProductToBasketDetail(Basket basket, long productId, int quantity){
        ProductDTO productDTO = productService.getProductById(productId);
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        basketDetailRepository.save(new BasketDetail(basket, product, product.getPrice(), quantity));
    }

    public void deleteAllBasketDetailByBasketId(long basketId){
        basketDetailRepository.deleteBasketDetailsByBasketId(basketId);
    }

    public void deleteBasketDetail(long basketDetailId){
        basketDetailRepository.deleteBasketDetailById(basketDetailId);
    }
}