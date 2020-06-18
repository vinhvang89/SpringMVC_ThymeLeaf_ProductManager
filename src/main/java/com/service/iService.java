package com.service;

import com.model.Product;

import java.util.List;

public interface iService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void update(int id, Product product);
    void remove( int id);
}
