package com.example.SpringbootRedis.repository;

import com.example.SpringbootRedis.model.Product;
import com.example.SpringbootRedis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ProductClassRepository extends JpaRepository<Product,Integer> {
}
