package ru.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecom.ecommerce.dto.BasketDTO;
import ru.ecom.ecommerce.mapper.BasketMapper;
import ru.ecom.ecommerce.model.Basket;
import ru.ecom.ecommerce.repository.BasketRepository;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final ClientService clientService;
    private final BasketDetailService basketDetailService;

    @Autowired
    public BasketService(BasketRepository basketRepository,
                         ClientService clientService,
                         BasketDetailService basketDetailService) {
        this.basketRepository = basketRepository;
        this.clientService = clientService;
        this.basketDetailService = basketDetailService;
    }

    public void addProductToBasket(long productId, int quantity) {
        long clientId = clientService.getCurrentClientDtoId();
        if (getBasketByClientId(clientId) == null) {
            createNewBasket(clientId);
        }
        Basket basket = basketRepository.findBasketByClientId(clientId);
        basketDetailService.addProductToBasketDetail(basket, productId, quantity);
    }

    public void deleteProductFromBasket(long basketDetailId) {
        basketDetailService.deleteBasketDetail(basketDetailId);
    }

    public BasketDTO getBasketDTOByClientId(long clientId) {
        return BasketMapper.INSTANCE
                .toDto(basketRepository.findBasketByClientId(clientId));
    }

    public void deleteBasketById(long basketId) {
        basketRepository.deleteBasketById(basketId);
    }

    private Basket getBasketByClientId(long clientId) {
        return basketRepository.findBasketByClientId(clientId);
    }

    private void createNewBasket(long clientId) {
        Basket basket = new Basket(clientService.findById(clientId));
        basketRepository.save(basket);
    }
}
