package com.springBootTest.springBootTest.service;


import com.springBootTest.springBootTest.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getSimilarProducts(String productId);
}
