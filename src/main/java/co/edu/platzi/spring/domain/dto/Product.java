package co.edu.platzi.spring.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Product {

	private int productId;
	private String name;
	private int categoryId;
	private BigDecimal price;
	private int stock;
	private boolean active;
	private Category category;
	
}
