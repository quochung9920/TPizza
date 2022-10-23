package com.tpizza.repository;

import java.util.List;

import com.tpizza.pojos.Product;

public interface ProductRepository {
    List<Product> getProducts(String name);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(int category);
    Product getProductById(int id);
    Product addProduct(Product product);
    Product updateProduct(int product, int amount);
}
