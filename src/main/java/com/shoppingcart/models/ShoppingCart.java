package com.shoppingcart.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * This class contains the list of shopping items
 * It also calculates total price & sales tax
 */

public class ShoppingCart {

	private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	
	public List<ShoppingCartItem> getItems() {
		return items;
	}
	
	public void addItem(ShoppingCartItem item) {
		items.add(item);
	}

	/**
	 * This method will iterate over the items in the cart
	 * and calculate the total price. 
	 * Returns 0 if there are no items in the cart.
	 * Results are rounded to 2 decimal place
	 */
	public BigDecimal getTotalPrice() {
		if(items.size() == 0) return new BigDecimal(0);
		
		BigDecimal totalPrice = new BigDecimal(0);
		totalPrice.setScale(Constants.TOTAL_PRICE_SCALING_PRECISION, RoundingMode.HALF_EVEN);
		for(ShoppingCartItem item : items) {
			totalPrice = totalPrice.add(
					item.getProduct()
					.getPrice()
					.multiply(BigDecimal.valueOf(item.getQuantity())));
		};
		return totalPrice;
	}

	/**
	 * 
	 * This method will calculate sales tax based on the total price
	 * and percentage as declared in Constants class
	 * Returns 0 if there are no items in the cart.
	 * Returns are rounded to 2 decimal place
	 */
	public BigDecimal getSalesTax() {
		
		if(items.size() == 0) return new BigDecimal(0);
		
		BigDecimal salesTax = new BigDecimal(0);
		salesTax = getTotalPrice()
				.multiply(new BigDecimal(Constants.SALES_TAX_PERCENTAGE))
				.divide(new BigDecimal("100.00")) ;

		return salesTax.setScale(Constants.TOTAL_PRICE_SCALING_PRECISION, RoundingMode.HALF_EVEN);
	}
	
	/**
	 * 
	 * This method will calculate sales tax based on the total price
	 * and percentage as declared in Constants class
	 * Returns 0 if there are no items in the cart.
	 * Returns are rounded to 2 decimal place
	 */
	public BigDecimal getTotalPriceWithSalesTax() {
		
		if(items.size() == 0) return new BigDecimal(0);
		
		BigDecimal totalPriceWithTax = new BigDecimal(0);
		
		totalPriceWithTax = getTotalPrice().add(getSalesTax());
		
		return totalPriceWithTax.setScale(Constants.TOTAL_PRICE_SCALING_PRECISION, RoundingMode.HALF_EVEN);
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null) return false;
		if (o.getClass() != this.getClass()) {
            return false;
        }
		if(this == o) return true;
		
		ShoppingCart cart = (ShoppingCart) o;
		return this.getItems().size() == cart.getItems().size() &&
				this.getItems().equals(cart.getItems());		
		
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(items);
    }
}


