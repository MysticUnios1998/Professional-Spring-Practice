package co.edu.platzi.spring.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.platzi.spring.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
	
	List<Producto> findByCategoriaID(int categoriaID);

}
