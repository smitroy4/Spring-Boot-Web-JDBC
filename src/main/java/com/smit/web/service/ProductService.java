package com.smit.web.service;
import com.smit.web.models.Products;
import com.smit.web.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
private ProductRepo repo;

    public ProductRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(ProductRepo repo) {
        this.repo = repo;
    }

    public void addProduct(Products p){
        repo.save(p);
    }
public List <Products> getProduct(){
        return repo.findAll();
}
}
