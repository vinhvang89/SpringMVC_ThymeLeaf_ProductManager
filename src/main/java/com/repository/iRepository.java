package com.repository;

import com.model.Product;

import java.util.List;

public interface iRepository {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void  update(int id, Product product);
    void remove(int id);
}
