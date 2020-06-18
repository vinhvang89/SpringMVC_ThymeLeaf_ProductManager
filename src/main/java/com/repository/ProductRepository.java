package com.repository;

import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository  implements iRepository{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "GTFS", "Fender Stratocaster", 1200));
        products.put(2, new Product(2, "GTFT", "Fender Telecaster", 1400));
        products.put(3, new Product(3, "GTLP", "Gibson Les Paul", 2200));
        products.put(4, new Product(4, "GTGS", "Gibson SG", 1410));
        products.put(5, new Product(5, "GTFV", "Gibson Flying V", 13200));
        products.put(6, new Product(6, "GTSS", "Superstrat", 4200));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
