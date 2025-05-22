package com.example.goldshop.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "product_source_id")
    private ProductSource productSource;

    private BigDecimal priceEstimate;

    private BigDecimal weightCaratNullable;

    private Integer quantity;

    private Timestamp createdAt;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImage> images;
}
