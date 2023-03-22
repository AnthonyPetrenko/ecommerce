package ru.ecom.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ecom.ecommerce.dto.ProductDTO;
import ru.ecom.ecommerce.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    private String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products_list";
    }

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") long id, Model model) {
        ProductDTO productDto = productService.getProductById(id);
        model.addAttribute("product", productDto);
        return "product_info";
    }

    @GetMapping("/products/add_new_product")
    public String addNewProductPage(){
        return "add_new_product";
    }

    @PostMapping("/products/add_new_product")
    public String addNewProductToList(@ModelAttribute("product") ProductDTO productDTO){
        productService.addNewProduct(productDTO);
        return "redirect:/products";
    }

    @PostMapping("/products/delete")
    public String deleteProductByName(@ModelAttribute("name") String name){
        productService.deleteProductByName(name);
        return "redirect:/products";
    }
}