package com.arun.Product_Inventory.Controller;

import com.arun.Product_Inventory.Model.Product;
import com.arun.Product_Inventory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable int id){
        service.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    @PutMapping("/products/{id}/stock/add")
    public void increaseProductQuantity(@RequestParam int quantity,@PathVariable int id){
        service.increaseProductQuantity(id, quantity);
    }

    @PutMapping("/products/{id}/stock/remove")
    public void decreaseProductQuantity(@RequestParam int quantity,@PathVariable int id){
        service.decreaseProductQuantity(id, quantity);
    }
}
