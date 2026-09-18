package com.arun.Product_Inventory.DAO;

import com.arun.Product_Inventory.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThanEqual(double price);

    List<Product> findByQuantityLessThan(int quantity);
}
