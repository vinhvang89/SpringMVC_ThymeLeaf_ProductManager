package com.service;

import com.model.Product;
import com.repository.ProductRepository;

import java.util.List;

public class ProductService implements iService {
    public ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id,Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }
}
