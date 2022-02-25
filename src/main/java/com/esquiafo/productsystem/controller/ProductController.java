package com.esquiafo.productsystem.controller;

import com.esquiafo.productsystem.model.Product;
import com.esquiafo.productsystem.repository.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getAProduct(@PathVariable int id) {
        Optional<Product> user = productService.getById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            throw new  RecordNotFoundException();
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody final Product product) {
        Product products = productService.saveProduct(product);
        if (products == null) {
            throw new ServerException();
        }
        else {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(){

        productService.deletedAll();
        return ResponseEntity.ok().build();
    }
}
