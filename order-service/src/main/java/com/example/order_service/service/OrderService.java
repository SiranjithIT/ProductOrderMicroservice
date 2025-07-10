package com.example.order_service.service;


import com.example.common_dto.dto.ProductDto;
import com.example.order_service.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private ProductClient client;

    public List<ProductDto> getProducts(){
        return client.getProducts();
    }

    public ProductDto getProductById(Long id) {
        return client.getProduct(id);
    }
}
