package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product>products = new ArrayList<>();
    static {
        products.add(new Product(1, "Iphone11", 12000000, "old", "Apple"));
        products.add(new Product(2, "Iphone12", 15000000, "new", "Apple"));
        products.add(new Product(3, "Iphone13", 18000000, "new", "Apple"));
        products.add(new Product(4, "Galaxy1", 10000000, "old", "SamSung"));
        products.add(new Product(5, "Galaxy2", 10000000, "new", "SamSung"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
    public int findProductById(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                index = i;
            }
        }
        return index;
    }
    @Override
    public Product findById(int id) {
        int index = findProductById(id);
       if (index!=-1){
           return products.get(index);
       }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        int index = findProductById(id);
        products.set(index, product);
    }

    @Override
    public void delete(int id) {
        int index = findProductById(id);
        products.remove(index);
    }
    public Product findProductByName (String name){
        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())){
                return products.get(i);
            }
        }
        return null;
    }
}
