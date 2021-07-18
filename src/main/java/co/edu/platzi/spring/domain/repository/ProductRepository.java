package co.edu.platzi.spring.domain.repository;

import java.util.List;
import java.util.Optional;

import co.edu.platzi.spring.domain.Product;

public interface ProductRepository {

	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<Product> getProductById(int productId);
	Optional<Product> save(Product product);
	void deleteProductById(int productId);
	
}
