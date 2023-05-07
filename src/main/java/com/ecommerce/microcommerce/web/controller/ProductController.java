package com.ecommerce.microcommerce.web.controller;


import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.dao.ProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    List<Product> prodlist = new ArrayList<>();


    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/Produits")
    public  List<Product> listeProduits (){
        return productDao.findAll();
    }
    @GetMapping("/Produits/{id}")
    public Product AfficherUnProduit(@PathVariable(name = "id") int id) {
        return productDao.findById(id);
    }
    @PostMapping("Produits")
    public void ajouterProduit(@RequestBody Product product){
        productDao.save(product);
    }


}
