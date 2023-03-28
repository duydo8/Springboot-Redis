package com.example.SpringbootRedis.controller;

import com.example.SpringbootRedis.common.Response;
import com.example.SpringbootRedis.model.Product;

//import com.example.SpringbootRedis.repository.ProductRedisRepository;
import com.example.SpringbootRedis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@EnableCaching
public class ProductController {
    @Autowired
    private ProductService ProductService;
//    @Autowired
//    RedisTemplate redisTemplate;
    @PostMapping("save")

    public ResponseEntity<?> save(@RequestBody Product Product){

        return ResponseEntity.badRequest()
                .body(Response.builder()
                        .data(ProductService.save(Product))
                        .message("success")
                        .status(200)
                        .build());

    }
    @PostMapping("update")
    @CachePut(value = "products", key = "#product.id")
    public ResponseEntity<?> update(@RequestBody Product product){

        Product x= ProductService.findById(product.getId());
        if(x==null){
            return ResponseEntity.badRequest()
                    .body(Response.builder()
                            .message("not found")
                            .status(400)
                            .build());
        }else{
            return ResponseEntity.badRequest()
                    .body(Response.builder()
                            .data(x)
                            .message("success")
                            .status(200)
                            .build());
        }

    }
    @GetMapping("{id}")
    @Cacheable(value = "products", key = "#product.id")
    public ResponseEntity<?> findById(@PathVariable int id){
        Product x= ProductService.findById(id);
        if(x==null){
            return ResponseEntity.badRequest()
                    .body(Response.builder()
                            .message("not found")
                            .status(400)
                            .build());
        }else{
            return ResponseEntity.badRequest()
                    .body(Response.builder()
                            .data(x)
                            .message("success")
                            .status(200)
                            .build());
        }
    }
    @GetMapping("")

    public ResponseEntity<?> findAll(){
        return ResponseEntity.badRequest()
                .body(Response.builder()
                        .data(ProductService.findAll())
                        .message("success")
                        .status(200)
                        .build());
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "products", key="#product.id")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        Integer x= ProductService.deleteById(id);
        if(x==null){
            return ResponseEntity.badRequest()
                    .body(Response.builder()
                            .message("not found")
                            .status(400)
                            .build());
        }else{
            return ResponseEntity.badRequest()
                    .body(Response.builder()
                            .message("success")
                            .status(200)
                            .build());
        }
    }
}
