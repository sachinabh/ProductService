package com.scaler.ProductService.services;

import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product updateProduct(Long id);
    Product replaceProduct(Long id);
    void deleteProduct(Long id);
}
