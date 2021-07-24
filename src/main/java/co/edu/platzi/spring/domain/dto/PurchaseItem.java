package co.edu.platzi.spring.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PurchaseItem {

	private int productId;
	private int quantity;
	private BigDecimal totalPrice;
	private boolean active;
	
}
