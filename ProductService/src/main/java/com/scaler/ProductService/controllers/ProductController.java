package com.scaler.ProductService.controllers;

import com.scaler.ProductService.ProductServiceApplication;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){

        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category){
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return productService.getCategories();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
    }
}
