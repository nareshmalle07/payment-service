package com.amazon.payment_service.repository;

import com.amazon.payment_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName (String name);
	
	List<Product> findByActiveTrue();
	
	Boolean existsByName(String name);
	
}
