package com.shoppingcart.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ShoppingCartItemTest {
	
	private String doveSoapName = Constants.DOVE_SOAP_NAME;
	private String doveSoapPrice = Constants.DOVE_SOAP_UNIT_PRICE;

	
	@Test
	@DisplayName("Test to create a new Shopping Cart Item")
	public void testCreatingNewShoppingCartItem() {
		
		Product doveSoapProduct1 = getDoveSoapProduct();
		Product doveSoapProduct2 = getDoveSoapProduct();
		ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(doveSoapProduct1, 1);
		ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(doveSoapProduct2, 1);
		assertTrue(shoppingCartItem1.equals(shoppingCartItem2));
	}
	
	@Test
	@DisplayName("When invalid quantity found test should fail")
	public void testForNonMatchingQuantityInCart() {
		
		Product doveSoapProduct1 = getDoveSoapProduct();
		Product doveSoapProduct2 = getDoveSoapProduct();
		ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(doveSoapProduct1, 1);
		ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(doveSoapProduct2, 2);
		assertFalse(shoppingCartItem1.equals(shoppingCartItem2));
	}
	
	//Method to instantiate & return a new DoveSoap Product
		private Product getDoveSoapProduct() {	
			BigDecimal price = new BigDecimal(doveSoapPrice);
			return new Product(doveSoapName, price);
		}	

}
