package com.example.order_service.client;

import com.example.common_dto.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@FeignClient(name = "product-service", url = "http://product-service:8082")
public interface ProductClient {
    @GetMapping("/products")
    public List<ProductDto> getProducts();
}
