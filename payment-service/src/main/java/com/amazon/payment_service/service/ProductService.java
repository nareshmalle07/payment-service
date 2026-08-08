package com.amazon.payment_service.service;

import com.amazon.payment_service.Exception.ProductNotFoundException;
import com.amazon.payment_service.dto.ProductRequest;
import com.amazon.payment_service.dto.ProductResponse;
import com.amazon.payment_service.entity.Product;
import com.amazon.payment_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductResponse insertProduct(ProductRequest request) {
//		return productRepository.save(request);

		Product product = new Product();

		product.setPrice(request.getPrice());
		product.setName(request.getName());
		product.setActive(request.getActive());

		Product saveProduct = productRepository.save(product);

		ProductResponse response = new ProductResponse();
		response.setId(saveProduct.getId());
		response.setName(saveProduct.getName());
		response.setPrice(saveProduct.getPrice());

		return response;
	}

	public Product findById(Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("product not found"));
	}

	public List<Product> getActiveProducts() {
		System.out.println(" service Fetching active products...");
		System.out.println("productRepository count is"+productRepository.count());
		return productRepository.findByActiveTrue();
	}

	public String deactivateProduct(Long ProductID) {
		//Product product = new Product();
		Product product = productRepository.findById(ProductID).orElseThrow(() -> new ProductNotFoundException("product not found"));
		product.setActive(false);

		productRepository.save(product);

		return "Product-"+ ProductID+" Deactivated";
	}

	public List<Product> getProduct() {

		return productRepository.findAll();
	}

}
