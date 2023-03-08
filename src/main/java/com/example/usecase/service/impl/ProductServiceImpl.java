package com.example.usecase.service.impl;

import com.example.usecase.exception.ProductNotFound;
import com.example.usecase.model.Product;
import com.example.usecase.repository.ProductRepository;
import com.example.usecase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public List<Product> searchByProductName(String name) {
//        List<Product> products = (List<Product>) productRepository.findByProductName(name);

        List<Product> products = (List<Product>) productRepository.findByRegex("^"+name);
        if(products == null) {
            throw new RuntimeException("No Product with this name is available");
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public String productStatus(String id) throws ProductNotFound {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Product Not found"));

        int quantityZero = 0;
        if(quantityZero == 0)
        product.setProductStatus("Out of Stock");

        productRepository.save(product);

        return "Product Status Updated Successfull";
    }

    @Override
    public String deleteProduct(String id) {
//        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Username not found"));
        boolean f = productRepository.existsById(id);
        if(!f){
            return "Product is Not Available";
        }
        productRepository.deleteById(id);
        return "Deleted Successfuly";
    }
}
