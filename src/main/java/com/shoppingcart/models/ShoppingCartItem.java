package com.shoppingcart.models;

import java.util.Objects;

/**
 * 
 * This class represents individual items in the shopping cart 
 * along with quantity added
 */

public class ShoppingCartItem {
	
	private Product product;
	private Integer quantity;
	
	
	public ShoppingCartItem(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null) return false;
		if (o.getClass() != this.getClass()) {
            return false;
        }
		if(this == o) return true;
		
		ShoppingCartItem item = (ShoppingCartItem) o;
		return this.getProduct().equals(item.getProduct()) && 
				this.getQuantity().equals(item.getQuantity());		
		
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

}
