package com.example.SpringbootRedis.service;

import com.example.SpringbootRedis.model.Product;


import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product findById(Integer id);
    List<Product> findAll();
    Integer deleteById(Integer id);
    Product update(Product product);
}
