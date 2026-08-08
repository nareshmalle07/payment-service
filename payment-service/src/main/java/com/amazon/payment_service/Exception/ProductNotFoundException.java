package com.amazon.payment_service.Exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String message) 
	{
		super(message);
	}
}
