package com.example.goldshop.model.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pawnitems")
public class PawnItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pawn_record_id")
    private PawnRecord pawnRecord;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal evaluatedPrice;

    private String status;
}