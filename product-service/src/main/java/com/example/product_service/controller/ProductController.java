package com.example.product_service.controller;

import com.example.common_dto.dto.ProductDto;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/products")
    public String createProduct(@RequestBody ProductDto product) {
        service.createProduct(product);
        return "Product created successfully";
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable Long id){return service.getProductById(id);}

    @PutMapping("/product/{id}&{quantity}")
    public String quantityDecrement(@PathVariable Long id, @PathVariable int quantity) {
        service.quantityDecrement(id, quantity);
        return "Product quantity updated successfully";
    }
}
