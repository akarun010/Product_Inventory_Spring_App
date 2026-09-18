package com.arun.Product_Inventory.DAO;

import com.arun.Product_Inventory.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
