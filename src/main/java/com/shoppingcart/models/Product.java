package com.shoppingcart.models;

import java.math.BigDecimal;
import java.util.Objects;


public class Product {

	private String name;
	private BigDecimal price;
	
	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null) return false;
		if (o.getClass() != this.getClass()) {
            return false;
        }
		if(this == o) return true;
		
		Product product = (Product) o;
		return this.getName().equals(product.getName()) && 
				this.getPrice().equals(product.getPrice());		
		
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

	
}
