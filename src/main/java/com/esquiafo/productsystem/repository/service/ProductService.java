package com.esquiafo.productsystem.repository.service;

import com.esquiafo.productsystem.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllProduct();
    public Optional<Product> getById(int id);
    public void deletedAll();

}
