package com.example.product_service.service;

import com.example.product_service.model.Product;
import com.example.common_dto.dto.ProductDto;
import com.example.product_service.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void createProduct(ProductDto product){
        Product newProd = new Product();
        newProd.setName(product.getName());
        newProd.setQuantity(product.getQuantity());
        newProd.setPrice(product.getPrice());
        productRepo.save(newProd);
    }

    private ProductDto convertToDto(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getQuantity());
    }

    public List<ProductDto> getProducts(){
        return productRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id){
        return productRepo.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public void quantityDecrement(Long id, int quantity) {
        Product entity = productRepo.findById(id).orElse(null);
        if (entity != null) {
            entity.setQuantity(entity.getQuantity() - quantity);
            productRepo.save(entity);
        }
    }

}
