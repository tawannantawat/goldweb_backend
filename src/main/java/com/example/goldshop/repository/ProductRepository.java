package com.example.goldshop.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.goldshop.model.dto.ProductWithImageDTO;
import com.example.goldshop.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByProductType_Name(String typeName);

    List<Product> findByProductSource_Name(String sourceName);

    List<Product> findByWeightCaratNullableBetween(BigDecimal min, BigDecimal max);

    List<Product> findByPriceEstimateLessThan(BigDecimal maxPrice);

    @Query("""
    SELECT new com.example.goldshop.model.dto.ProductWithImageDTO(
        p.id,
        p.name,
        p.priceEstimate,
        pt.name,
        p.weightCaratNullable,
        i.imageUrl
    )
    FROM Product p
    LEFT JOIN p.productType pt
    LEFT JOIN p.images i
    WHERE (:name IS NULL OR :name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
    AND (:type IS NULL OR pt.name = :type)
    AND (:maxPrice IS NULL OR p.priceEstimate <= :maxPrice)
    """)
    List<ProductWithImageDTO> findFilteredProducts(
        @Param("name") String name,
        @Param("type") String type,
        @Param("maxPrice") BigDecimal maxPrice
    );
}
