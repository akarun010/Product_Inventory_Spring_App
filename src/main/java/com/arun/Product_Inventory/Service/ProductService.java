package com.arun.Product_Inventory.Service;

import com.arun.Product_Inventory.DAO.ProductDAO;
import com.arun.Product_Inventory.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDAO dao;

    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return dao.findById(id);
    }

    public void addProduct(Product product) {
        dao.save(product);
    }

    public void updateProduct(int id, Product product) {
        Optional<Product> optionalProduct = dao.findAll().stream().filter(p -> p.getId() == id).findFirst();
        if(optionalProduct.isPresent()){
            Product product1 = optionalProduct.get();
            product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setCategory(product.getCategory());
            product1.setPrice(product.getPrice());
            product1.setQuantity(product.getQuantity());
            dao.save(product1);
        }
    }

    public void deleteProduct(int id) {
        Optional<Product> optionalProduct = dao.findAll().stream().filter(p -> p.getId() == id).findFirst();
        optionalProduct.ifPresent(product -> dao.delete(product));
    }

    public void increaseProductQuantity(int id, int quantity) {
        Optional<Product> optionalProduct = dao.findAll().stream().filter(p -> p.getId() == id).findFirst();
        if(optionalProduct.isPresent()){
            Product product1 = optionalProduct.get();
            product1.setQuantity(product1.getQuantity() + quantity);
            dao.save(product1);
        }
    }

    public void decreaseProductQuantity(int id, int quantity) {
        Optional<Product> optionalProduct = dao.findAll().stream().filter(p -> p.getId() == id).findFirst();
        if(optionalProduct.isPresent()){
            Product product1 = optionalProduct.get();
            product1.setQuantity(product1.getQuantity() - quantity);
            dao.save(product1);
        }
    }
}
