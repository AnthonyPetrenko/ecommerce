package ru.ecom.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ecom.ecommerce.dto.BasketDTO;
import ru.ecom.ecommerce.dto.BasketDetailDTO;
import ru.ecom.ecommerce.service.*;

import java.util.List;

@Controller
public class BasketController {

    private final BasketService basketService;
    private final BasketDetailService basketDetailService;
    private final TransferService transferService;
    private final ClientService clientService;

    @Autowired
    public BasketController(BasketService basketService,
                            BasketDetailService basketDetailService,
                            TransferService transferService,
                            ClientService clientService) {
        this.basketService = basketService;
        this.basketDetailService = basketDetailService;
        this.transferService = transferService;
        this.clientService = clientService;
    }

    @GetMapping("/basket")
    public String getProductsInClientBasket(Model model){
        BasketDTO basketDTO = basketService.getBasketDTOByClientId(clientService.getCurrentClientDtoId());
        if (basketDTO != null) {
            List<BasketDetailDTO> basketDetailDTOList = basketDetailService.getBasketDetailListByBasketId(basketDTO.getId());
            model.addAttribute("basketDetails", basketDetailDTOList);
            model.addAttribute("totalPrice", basketDetailService.getBasketDetailPriceSum(basketDetailDTOList));
            model.addAttribute("basket", basketDTO);
        }
        return "basket";
    }

    @PostMapping("/products/add")
    public String addProductToBasket(@RequestParam("productId") long productId,
                                     @RequestParam("quantity") int quantity) {
        basketService.addProductToBasket(productId, quantity);
        return "redirect:/products";
    }

    @PostMapping("/basket/delete")
    public String deleteProductFromBasket(@RequestParam("basketDetailId") long basketDetailId){
        basketService.deleteProductFromBasket(basketDetailId);
        return "redirect:/basket";
    }

    @PostMapping("/basket/make_order")
    public String makeOrder(@RequestParam("basketId") long basketId){
        transferService.transferBasketDetailsToOrderDetails(basketId,clientService.getCurrentClientDtoId());
        return "redirect:/basket";
    }

}
