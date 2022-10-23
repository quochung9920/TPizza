package com.tpizza.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpizza.pojos.Product;
import com.tpizza.service.ProductService;

@RestController
@RequestMapping("/api")
public class ApiProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add-product", produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Product> addProduct(@RequestBody Map<String, String> params) {
        try {
            String name = params.get("name");
            String content = params.get("content");
            int price = Integer.parseInt(params.get("price"));
            int amount = Integer.parseInt(params.get("amount"));
            int idCategory = Integer.parseInt(params.get("category"));
            String image = params.get("image");
            
            Product product = this.productService.addProduct(name, content, price, amount, idCategory, image);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/products", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> products = this.productService.getProducts("");
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/products/{category}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable(name = "category") String category) {
        try {
            List<Product> products = this.productService.getProductsByCategory(category);
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/updateProduct/{idProduct}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Product> editProduct(@RequestBody Map<String, String> params, @PathVariable(name = "idProduct") int idProduct) {
        try {
            int amount = Integer.parseInt(params.get("amountProduct"));
            return new ResponseEntity<Product>(this.productService.updateProduct(idProduct, amount), HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
