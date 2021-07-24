package co.edu.platzi.spring.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.platzi.spring.domain.dto.Purchase;
import co.edu.platzi.spring.domain.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public List<Purchase> getAll(){
		return purchaseRepository.getAll();
	}
	
	public Optional<Purchase> getById(int purchaseId){
		return purchaseRepository.getById(purchaseId);
	}
	
	public Optional<List<Purchase>> getByClientId(String clientId){
		return purchaseRepository.getByClientId(clientId);
	}
	
	public Optional<Purchase> save(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

}
