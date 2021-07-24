package co.edu.platzi.spring.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.platzi.spring.domain.dto.Product;
import co.edu.platzi.spring.domain.repository.ProductRepository;
import co.edu.platzi.spring.persistence.crud.ProductoCrudRepository;
import co.edu.platzi.spring.persistence.entity.Producto;
import co.edu.platzi.spring.persistence.mapper.ProductMapper;


@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Optional<Product> getProductById(int id){
		return productoCrudRepository.findById(id).map(productMapper::toProduct);
	}
	
	@Override
	public List<Product> getAll(){
		return productMapper.toProductList((List<Producto>) productoCrudRepository.findAll());
	}
	
	@Override
	public Optional<Product> save(Product product) {
		return Optional.of(productoCrudRepository.save(productMapper.toProducto(product))).map(productMapper::toProduct);
	}
	
	@Override
	public void deleteProductById(int productoId) {
		productoCrudRepository.deleteById(productoId);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		return Optional.of(productMapper.toProductList(productoCrudRepository.findByCategoriaID(categoryId)));
	}

	
}
