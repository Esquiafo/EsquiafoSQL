package com.esquiafo.productsystem.controller;

import com.esquiafo.productsystem.model.Product;
import com.esquiafo.productsystem.repository.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String add(@RequestBody Product product){
        productService.saveProduct(product);
        return "New product added";
    }
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id) {
        Optional<Product> user = productService.getById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            throw new  RecordNotFoundException();
        }
    }
}
