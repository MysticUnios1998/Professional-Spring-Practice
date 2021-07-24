package co.edu.platzi.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.platzi.spring.domain.dto.Purchase;
import co.edu.platzi.spring.domain.service.PurchaseService;

@RestController
@RequestMapping(value="/purchases")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{purchaseId}")
	public ResponseEntity<?> getById(@PathVariable("purchaseId") int purchaseId) {
		return purchaseService.getById(purchaseId)
				.map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/client/{clientId}")
	public ResponseEntity<?> getByClientId(@PathVariable("clientId") String clientId) {
		return purchaseService.getByClientId(clientId)
				.map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Purchase purchase){
		return purchaseService.save(purchase)
				.map(pur -> new ResponseEntity<>(pur, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
}
