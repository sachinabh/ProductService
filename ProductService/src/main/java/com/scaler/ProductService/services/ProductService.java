package com.scaler.ProductService.services;

import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductsByCategory(String category);
    List<Category> getCategories();
    Product updateProduct(Long id);
    Product replaceProduct(Long id);
    void deleteProduct(Long id);
}
