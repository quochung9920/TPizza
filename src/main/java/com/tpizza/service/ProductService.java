package com.tpizza.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tpizza.pojos.Product;

public interface ProductService {
    List<Product> getProducts(String name);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product getProductById(int id);

    Product addProduct(String name, String content, int price, int amount, int idCategory, String image);
    boolean addProductImage(MultipartFile file);
    Product updateProduct(int product, int amount); 
}
