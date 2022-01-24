package com.shoppingcart.models;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ProductTest {
	
	private Product item1, item2;
	BigDecimal price;
	String productName;
	
	@BeforeEach
	public void setup() {
		price = BigDecimal.valueOf(39.99);
		productName = "Dove Soap";
		
	}
	
	@AfterEach
	public void cleanUp() {
		item1 = null;
		item2 = null;
		price = null;
		productName = null;
	}
	
	@Test
	@DisplayName("Assert creation of a product")
	public void createNewProductTest() {
		item1 = new Product(productName, price);
		item2 = new Product(productName, price);
		assertTrue(item1.equals(item2));
	}
	
}

