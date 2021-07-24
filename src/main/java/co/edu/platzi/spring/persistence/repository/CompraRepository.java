package co.edu.platzi.spring.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.platzi.spring.domain.dto.Purchase;
import co.edu.platzi.spring.domain.repository.PurchaseRepository;
import co.edu.platzi.spring.persistence.crud.CompraCrudRepository;
import co.edu.platzi.spring.persistence.entity.Compra;
import co.edu.platzi.spring.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository {

	@Autowired
	private CompraCrudRepository compraCrudRepository;
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Override
	public List<Purchase> getAll() {
		return purchaseMapper.toPurchases((List<Compra>)compraCrudRepository.findAll());
	}

	@Override
	public Optional<Purchase> getById(int purchaseId) {
		return compraCrudRepository.findById(purchaseId)
				.map(purchaseMapper::toPurchase);
	}

	@Override
	public Optional<List<Purchase>> getByClientId(String clientId) {
		return compraCrudRepository.findByClienteID(clientId)
				.map(purchaseMapper::toPurchases);
	}

	@Override
	public Optional<Purchase> save(Purchase purchase) {
		var compra = purchaseMapper.toCompra(purchase);
		compra.getProductos()
			.forEach(producto -> producto.setCompra(compra));
		
		return Optional.ofNullable(compraCrudRepository.save(compra)).map(purchaseMapper::toPurchase);
	}

	@Override
	public boolean deleteById(int purchaseId) {
		// TODO Auto-generated method stub
		return false;
	}

}
