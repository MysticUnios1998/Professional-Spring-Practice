package co.edu.platzi.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.platzi.spring.domain.dto.Product;
import co.edu.platzi.spring.domain.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") int productId) {
		return productService.getProduct(productId)
				.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getByCategory(@PathVariable("id") int categoryId) {
		return productService.getByCategory(categoryId)
				.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Product product) {
		return productService.save(product)
				.map(p -> new ResponseEntity<>(p, HttpStatus.CREATED))
				.get();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int productId) {
		return new ResponseEntity<>((productService.deleteProduct(productId)) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
}
