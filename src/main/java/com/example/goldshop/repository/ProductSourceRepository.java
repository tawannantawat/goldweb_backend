package com.example.goldshop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.goldshop.model.entity.ProductSource;

@Repository
public interface ProductSourceRepository extends JpaRepository<ProductSource, Long> {

    Optional<ProductSource> findByName(String name);
}
