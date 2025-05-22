package com.example.goldshop.model.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
@Entity
@Table(name = "loginlogs")
public class LoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Timestamp loginTime;

    private String ipAddress;

    @Column(columnDefinition = "text")
    private String userAgent;
}
