package com.example.goldshop.model.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWithImageDTO {
    private Integer id;
    private String name;
    private BigDecimal priceEstimate;
    private String type;
    private BigDecimal weight;
    private String imageUrl;

    public ProductWithImageDTO(Integer id, String name, BigDecimal priceEstimate, String type, BigDecimal weight, String imageUrl) {
        this.id = id;
        this.name = name;
        this.priceEstimate = priceEstimate;
        this.type = type;
        this.weight = weight;
        this.imageUrl = imageUrl;
    }
}
