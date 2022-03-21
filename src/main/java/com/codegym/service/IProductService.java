package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    void create(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product findProductByName(String name);
}
