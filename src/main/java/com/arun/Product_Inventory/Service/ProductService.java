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
        Product product1 = dao.findById(id).orElseThrow(() -> new RuntimeException("Product Is Not Available In The Server"));
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        dao.save(product1);
    }

    public void deleteProduct(int id) {
        Product product = dao.findById(id).orElseThrow(() -> new RuntimeException("Product Is Not Available In The Server"));
        dao.delete(product);
    }

    public void increaseProductQuantity(int id, int quantity) {
        Product product = dao.findById(id).orElseThrow(() -> new RuntimeException("Product Is Not Available In The Server"));
        if(quantity > 0){
            product.setQuantity(product.getQuantity() + quantity);
            dao.save(product);
        }
    }

    public void decreaseProductQuantity(int id, int quantity) {
        Product product = dao.findById(id).orElseThrow(() -> new RuntimeException("Product Is Not Available In The Server"));
        if(quantity > 0){
            if(product.getQuantity() - quantity >= 0){
                product.setQuantity(product.getQuantity() - quantity);
                dao.save(product);
            }
        }
    }

    public List<Product> getProductByCategory(String category) {
        return dao.findByCategory(category);
    }

    public List<Product> getProductByPrice(double price) {
        return dao.findByPriceLessThanEqual(price);
    }

    public List<Product> getProductByLowQuantity(int quantity) {
        return dao.findByQuantityLessThan(quantity);
    }
}
