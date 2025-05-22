package com.example.goldshop.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.goldshop.model.dto.ProductWithImageDTO;
import com.example.goldshop.model.entity.Product;
import com.example.goldshop.repository.ProductRepository;
import com.example.goldshop.repository.RecommendedProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final RecommendedProductRepository recommendedProductRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,RecommendedProductRepository recommendedProductRepository) {
        this.productRepository = productRepository;
        this.recommendedProductRepository = recommendedProductRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Product> getByType(String typeName) {
        return productRepository.findByProductType_Name(typeName);
    }

    public List<Product> filterByWeight(BigDecimal min, BigDecimal max) {
        return productRepository.findByWeightCaratNullableBetween(min, max);
    }

    public List<Product> filterByMaxPrice(BigDecimal maxPrice) {
        return productRepository.findByPriceEstimateLessThan(maxPrice);
    }

    public List<ProductWithImageDTO> getRecommendedProducts() {
    return recommendedProductRepository.findRecommendedProductsWithImages();
    }

    public List<ProductWithImageDTO> filterProducts(String name, String type, BigDecimal maxPrice) {
    return productRepository.findFilteredProducts(name, type, maxPrice);
    }

}