package com.prashantjain.yummyrest.mapper;

import com.prashantjain.yummyrest.dto.CustomerRequest;
import com.prashantjain.yummyrest.dto.ProductsRequest;
import com.prashantjain.yummyrest.dto.ProductsResponse;
import com.prashantjain.yummyrest.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper {
    public Products toEntity(ProductsRequest request) {
        return Products.builder()
                .productName(request.productName())
                .price(request.price())
                .build();
    }
}