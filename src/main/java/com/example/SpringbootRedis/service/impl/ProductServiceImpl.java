package com.example.SpringbootRedis.service.impl;

import com.example.SpringbootRedis.model.Product;
import com.example.SpringbootRedis.repository.ProductClassRepository;

import com.example.SpringbootRedis.service.ProductService;
import com.example.SpringbootRedis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductClassRepository ProductRepository;
    @Override
    public Product save(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public Product findById(Integer id) {
        return ProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return ProductRepository.findAll();
    }

    @Override
    public Integer deleteById(Integer id) {
        Optional<Product> Product= ProductRepository.findById(id);
        if(Product.isPresent()){
            ProductRepository.deleteById(id);
            return 1;
        }

        return 0;
    }

    @Override
    public Product update(Product product) {
        Optional<Product> Product= ProductRepository.findById(product.getId());
        if(Product.isPresent()){

            return ProductRepository.save(product);
        }

        return null;
    }
}
