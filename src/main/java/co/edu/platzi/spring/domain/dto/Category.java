package co.edu.platzi.spring.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Category {
	
	private int categoryId;
	private String category;
	private boolean active;

}
