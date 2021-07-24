package co.edu.platzi.spring.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.platzi.spring.domain.dto.Product;
import co.edu.platzi.spring.domain.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll(){
		return productRepository.getAll();
	}
	
	public Optional<Product> getProduct(int productId) {
		return productRepository.getProductById(productId);
	}
	
	public Optional<List<Product>> getByCategory(int categoryId) {
		return productRepository.getByCategory(categoryId);
	}
	
	public Optional<Product> save(Product product) {
		return productRepository.save(product);
	}
	
	public boolean deleteProduct(int productId) {
		return getProduct(productId).map(product -> {
			productRepository.deleteProductById(productId);
			return true;
		}).orElse(false);
	}

}
