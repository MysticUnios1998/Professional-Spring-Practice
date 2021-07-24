package co.edu.platzi.spring.domain.repository;

import java.util.List;
import java.util.Optional;

import co.edu.platzi.spring.domain.dto.Purchase;

public interface PurchaseRepository {

	List<Purchase> getAll();
	Optional<Purchase> getById(int purchaseId);
	Optional<List<Purchase>> getByClientId(String clientId);
	Optional<Purchase> save(Purchase purchase);
	boolean deleteById(int purchaseId);
	
}
