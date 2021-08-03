package zw.co.afrosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id){
        return service.getProduct(id);
    }
}
