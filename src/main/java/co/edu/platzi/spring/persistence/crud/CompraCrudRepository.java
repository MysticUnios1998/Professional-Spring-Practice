package co.edu.platzi.spring.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.platzi.spring.persistence.entity.Compra;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

	Optional<List<Compra>> findByClienteID(String clienteID);
	
}
