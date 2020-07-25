package com.supremepedro.validator.repository;

import com.supremepedro.validator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
