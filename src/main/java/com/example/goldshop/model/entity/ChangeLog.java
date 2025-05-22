package com.example.goldshop.model.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "changelogs")
public class ChangeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String tableName;

    private String operationType;

    private Integer recordId;

    @Column(columnDefinition = "text")
    private String description;

    private Timestamp createdAt;
}
