package com.springBootTest.springBootTest.client;

import com.springBootTest.springBootTest.dto.ProductDTO;
import com.springBootTest.springBootTest.dto.SimilarProductIdsDTO;
import com.springBootTest.springBootTest.exception.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalProductClientImpl implements ExternalProductClient {

    private final WebClient webClient;

    public ExternalProductClientImpl(@Value("${external.api.base-url}") String baseUrl, WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    @Override
    public List<SimilarProductIdsDTO> getSimilarProductIds(String productId) {
        try {

            String url = "/" + productId + "/similarids";
            SimilarProductIdsDTO[] response = webClient.get().uri(url).retrieve().bodyToMono(SimilarProductIdsDTO[].class).block();

            return Arrays.asList(response);


        } catch (Exception e) {
            throw new CustomException("Error intentando obtener IDs productos similares: " + e.getMessage());
        }
    }

    @Override
    public ProductDTO getProductDetails(Integer productId) {
        try {
            String url = "/" + productId;
            return webClient.get().uri(url).retrieve().bodyToMono(ProductDTO.class).block();
        } catch (Exception e) {
            throw new CustomException("Error intentando obtener detalles de productos similares: " + e.getMessage());
        }
    }
}

