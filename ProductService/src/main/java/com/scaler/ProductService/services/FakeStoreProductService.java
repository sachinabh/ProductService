package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.FakeStoreProductDto;
import com.scaler.ProductService.dtos.FakeStoreProductDtoList;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private List<Product> convertDtoListToProductList(FakeStoreProductDto[] fakeStoreProductDtoList){
        List<Product> productList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            productList.add(convertDtoToProduct(fakeStoreProductDto));
        }
        return productList;
    }

    private List<Product> convertDtoListToProductList(FakeStoreProductDtoList fakeStoreProductDtoList){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < fakeStoreProductDtoList.size(); i++) {
            productList.add(convertDtoToProduct(fakeStoreProductDtoList.get(i)));
        }
        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        assert fakeStoreProductDto != null;
        return convertDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        if (fakeStoreProductDtos == null){
            return null;
        }
        return convertDtoListToProductList(fakeStoreProductDtos);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category, FakeStoreProductDto[].class);
        assert fakeStoreProductDtos != null;
        if(fakeStoreProductDtos.length == 0) {
            return null;
        }
        return convertDtoListToProductList(fakeStoreProductDtos);
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
