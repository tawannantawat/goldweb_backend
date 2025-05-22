package com.example.goldshop.model.entity;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "pawnrecords")
public class PawnRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerName;

    private Date pawnDate;

    private Date dueDate;

    private BigDecimal interestRate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
}
