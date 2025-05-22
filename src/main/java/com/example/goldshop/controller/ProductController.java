package com.example.goldshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.goldshop.model.dto.ProductWithImageDTO;
import com.example.goldshop.model.entity.Product;
import com.example.goldshop.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET /api/products/search?name=แหวน
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchByName(name);
    }

    // GET /api/products/type?type=สร้อย
    @GetMapping("/type")
    public List<Product> getByType(@RequestParam String type) {
        return productService.getByType(type);
    }

    // GET /api/products/weight?min=0.5&max=3.0
    @GetMapping("/weight")
    public List<Product> filterByWeight(@RequestParam BigDecimal min,
                                        @RequestParam BigDecimal max) {
        return productService.filterByWeight(min, max);
    }

    // GET /api/products/price?max=15000
    @GetMapping("/price")
    public List<Product> filterByPrice(@RequestParam BigDecimal max) {
        return productService.filterByMaxPrice(max);
    }
    // GET /api/products/recommended
    @GetMapping("/recommended")
    public List<ProductWithImageDTO> getRecommendedProducts() {
        return productService.getRecommendedProducts();
    }

    // GET /api/products/filter?name=แหวน&type=แหวน&maxPrice=20000
    @GetMapping("/filter")
    public List<ProductWithImageDTO> filterProducts(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) BigDecimal maxPrice
    ) {
        return productService.filterProducts(name, type, maxPrice);
    }


}