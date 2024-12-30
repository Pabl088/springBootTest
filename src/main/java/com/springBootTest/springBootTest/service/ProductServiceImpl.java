package com.springBootTest.springBootTest.service;

import com.springBootTest.springBootTest.client.ExternalProductClient;
import com.springBootTest.springBootTest.dto.ProductDTO;
import com.springBootTest.springBootTest.dto.SimilarProductIdsDTO;
import com.springBootTest.springBootTest.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ExternalProductClient externalProductClient;

    @Override
    public List<ProductDTO> getSimilarProducts(String productId) {
        try {
            List<SimilarProductIdsDTO> similarProductIds = externalProductClient.getSimilarProductIds(productId);
            return similarProductIds.stream()
                    .map(id -> externalProductClient.getProductDetails(id.getId()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}
