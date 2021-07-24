package co.edu.platzi.spring.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Purchase {

	private int purchaseId;
	private String clientId;
	private LocalDateTime date;
	private String paymentMethod;
	private String comment;
	private String state;
	private List<PurchaseItem> items;
	
}
