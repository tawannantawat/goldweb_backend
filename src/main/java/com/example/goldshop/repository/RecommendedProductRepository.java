package com.example.goldshop.repository;

import com.example.goldshop.model.dto.ProductWithImageDTO;
import com.example.goldshop.model.entity.RecommendedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecommendedProductRepository extends JpaRepository<RecommendedProduct, Integer> {

    @Query("""
    SELECT new com.example.goldshop.model.dto.ProductWithImageDTO(
        r.product.id,
        r.product.name,
        r.product.priceEstimate,
        pt.name,
        r.product.weightCaratNullable,
        i.imageUrl
    )
    FROM RecommendedProduct r
    LEFT JOIN r.product.productType pt
    LEFT JOIN r.product.images i
    ORDER BY r.displayOrder ASC
    """)
    List<ProductWithImageDTO> findRecommendedProductsWithImages();
}
