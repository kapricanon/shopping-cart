package com.shoppingcart.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ShoppingCartTest {
	
	private String doveSoapName = Constants.DOVE_SOAP_NAME;
	private String doveSoapPrice = Constants.DOVE_SOAP_UNIT_PRICE;
	
	private String axeDeoName = Constants.AXE_DEO_NAME;
	private String axeDeoPrice = Constants.AXE_DEO_UNIT_PRICE;
	

	
	@Test
	@DisplayName("Check for empty cart on initialisation")
	public void emptyCartTest() {
		ShoppingCart emptyCart = new ShoppingCart();
		assertEquals(emptyCart.getItems().size(), 0);
		assertEquals(emptyCart.getTotalPrice(), new BigDecimal(0));
	}
	
	@Test
	@DisplayName("Test shopping cart total price after adding 5 dove soaps")
	public void testCartPriceAfterAddingFiveDoveSoaps() {
		ShoppingCart cart1 = new ShoppingCart();
		int quantity = 5;
		ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(getDoveSoapProduct(), quantity);
		cart1.addItem(shoppingCartItem1);
		ShoppingCart cart2 = new ShoppingCart();
		ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(getDoveSoapProduct(), quantity);
		cart2.addItem(shoppingCartItem2);
				
		assertTrue(cart1.equals(cart2));
		
		assertEquals(cart1.getTotalPrice(), new BigDecimal("199.95"));
	}
	
	@Test
	@DisplayName("Assert that the cart quantity is checked")
	public void testCartQuantityByProvidingIncorrectValue() {
		ShoppingCart cart1 = new ShoppingCart();
		int quantity1 = 5;
		int quantity2 = 6;
		ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(getDoveSoapProduct(), quantity1);
		cart1.addItem(shoppingCartItem1);
		ShoppingCart cart2 = new ShoppingCart();
		ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(getDoveSoapProduct(), quantity2);
		cart2.addItem(shoppingCartItem2);
				
		assertFalse(cart1.equals(cart2));
	}
	
	@Test
	@DisplayName("Test shopping cart total price after adding 8 dove soaps")
	public void testCartPriceAfterAddingEightDoveSoaps() {
		ShoppingCart cart1 = new ShoppingCart();
		int quantity = 8;
		ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(getDoveSoapProduct(), quantity);
		cart1.addItem(shoppingCartItem1);	
		
		ShoppingCart cart2 = new ShoppingCart();
		ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(getDoveSoapProduct(), quantity);
		cart2.addItem(shoppingCartItem2);	
		
		assertTrue(cart1.equals(cart2));
		
		assertEquals(cart1.getTotalPrice(), new BigDecimal("319.92"));
	}
	
	@Test
	@DisplayName("Test shopping cart total price after adding 2 dove soaps 2 Axe Deos Plus Sales Tax")
	public void testCartPriceAfterAddingTwoDoveSoapsTwoAxeDeosPlusSalesTax() {
		ShoppingCart cart1 = new ShoppingCart();
		
		//Add Dove Soap to Shopping Cart
		ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(getDoveSoapProduct(), 2);
		cart1.addItem(shoppingCartItem1);	
		
		//Add Axe Deo to Shopping Cart
		shoppingCartItem1 = new ShoppingCartItem(getAxeDeoProduct(), 2);
		cart1.addItem(shoppingCartItem1);	
		
		ShoppingCart cart2 = new ShoppingCart();
		
		//Add Dove Soap to Shopping Cart
		ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(getDoveSoapProduct(), 2);
		cart2.addItem(shoppingCartItem2);	
		
		//Add Axe Deo to Shopping Cart
		shoppingCartItem2 = new ShoppingCartItem(getAxeDeoProduct(), 2);
		cart2.addItem(shoppingCartItem2);	
		
		//Assert sales tax
		assertEquals(cart1.getSalesTax(), new BigDecimal("35.00"));
		
		//Validate items & quantity
		assertTrue(cart1.equals(cart2));
		
		//Validate total price including sales tax
		assertEquals(cart1.getTotalPriceWithSalesTax(), new BigDecimal("314.96"));
	}

	
	//Method to instantiate & return a new DoveSoap Product
	private Product getDoveSoapProduct() {	
		BigDecimal price = new BigDecimal(doveSoapPrice);
		return new Product(doveSoapName, price);
	}
	
	//Method to instantiate & return a new DoveSoap Product
	private Product getAxeDeoProduct() {	
		BigDecimal price = new BigDecimal(axeDeoPrice);
		return new Product(axeDeoName, price);
	}

}

