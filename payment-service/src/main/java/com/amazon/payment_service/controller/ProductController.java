package com.amazon.payment_service.controller;

import com.amazon.payment_service.dto.ProductRequest;
import com.amazon.payment_service.dto.ProductResponse;
import com.amazon.payment_service.entity.Product;
import com.amazon.payment_service.service.ProductService;//
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("/")
	public List<Product> getProduct()
	{
		return productService.getProduct();	
	}  
	
	@PostMapping("/insert")
	public ProductResponse insertProduct(@RequestBody ProductRequest request) 
	{
		return productService.insertProduct(request);
	}
	
	@PostMapping("/{productId}")
	public Product findById(@PathVariable Long productId) 
	{
		return productService.findById(productId);
	}
	
	@GetMapping("/active")
	public List<Product> getActiveProducts()
	{
		System.out.println("Fetching active products...");
		List<Product> productResponse= productService.getActiveProducts();
		System.out.println(" active products are ..."+productResponse);
		return productResponse;

	}
	
	@PostMapping("/deactivate/{ProductID}")
	public String deactivateProduct(@PathVariable Long ProductID)
	{
		return productService.deactivateProduct(ProductID);
	}
}
