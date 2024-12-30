package com.springBootTest.springBootTest.controller;

import com.springBootTest.springBootTest.dto.ProductDTO;
import com.springBootTest.springBootTest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDTO>> getSimilarProducts(@PathVariable String productId) {
        List<ProductDTO> similarProducts = productService.getSimilarProducts(productId);
        return ResponseEntity.ok(similarProducts);
    }
}
