package com.tpizza.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tpizza.pojos.Category;
import com.tpizza.pojos.Product;
import com.tpizza.repository.ProductRepository;
import com.tpizza.service.CategoryService;
import com.tpizza.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    private static String UPLOADED_FOLDER = "C:\\Users\\quoch\\Desktop\\Workspace\\java\\tpizza\\src\\main\\webapp\\resources\\images\\products\\";
    
    private static String DIRECTORY = "/images/products/";

    @Override
    public List<Product> getProducts(String name) {
        return this.productRepository.getProducts(name);
    }

    @Override
    public Product addProduct(String name, String content, int price, int amount, int idCategory, String image) {
        String imagePath = DIRECTORY + image;
        Product product = new Product();
        Category category = this.categoryService.getCategoryById(idCategory);

        product.setName(name);
        product.setContent(content);
        product.setPrice(price);
        product.setAmount(amount);
        product.setIdCategory(category);
        product.setImage(imagePath);
        
        return this.productRepository.addProduct(product);
    }


    @Override
    public boolean addProductImage(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        Category cat = this.categoryService.getCategoryByShortName(category);
        return this.productRepository.getProductsByCategory(cat.getId());
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public Product updateProduct(int product, int amount) {
        return this.productRepository.updateProduct(product, amount);
    }
    
}
