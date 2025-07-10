package com.example.order_service.controller;

import com.example.common_dto.dto.ProductDto;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/products")
    public List<ProductDto> getProducts(){
        return orderService.getProducts();
    }
}
