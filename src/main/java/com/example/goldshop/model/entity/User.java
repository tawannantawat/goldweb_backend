package com.example.goldshop.model.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    private Boolean isActive;

    private Timestamp createdAt;
}
