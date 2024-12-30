package com.springBootTest.springBootTest.client;

import com.springBootTest.springBootTest.dto.ProductDTO;
import com.springBootTest.springBootTest.dto.SimilarProductIdsDTO;

import java.util.List;

public interface ExternalProductClient {
    List<SimilarProductIdsDTO> getSimilarProductIds(String productId);

    ProductDTO getProductDetails(Integer productId);
}
