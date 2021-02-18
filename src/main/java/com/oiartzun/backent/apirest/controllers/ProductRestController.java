package com.oiartzun.backent.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oiartzun.backent.models.entity.Product;
import com.oiartzun.backent.models.filter.SearchFilter;
import com.oiartzun.backent.models.services.Implement.ProductServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductRestController {
	@Autowired 
	private ProductServiceImpl productServiceImpl;
	@GetMapping("/products")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> index() {
		return productServiceImpl.findAll();
	}
	@GetMapping("/products/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> byId(@PathVariable("id") Long id) {
		return productServiceImpl.getProductsById(id);
	}
	
	@GetMapping("/products/show/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product show(@PathVariable("id") Long id) {
		return productServiceImpl.findById(id);
	}
	
	@PostMapping("/products/search")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> search(@RequestBody SearchFilter search) {
		return productServiceImpl.search(search.filter);
	}

	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productServiceImpl.save(product);
	}
	
	@PutMapping("/products/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product productCurrent = productServiceImpl.findById(id);
		productCurrent.setName(product.getName());
		productCurrent.setInventaryCode(product.getInventaryCode());
		return productServiceImpl.save(productCurrent);
	}
	
	@DeleteMapping("/products/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		System.out.println("El valor del id es : " + id);
		productServiceImpl.delete(id);
	}


}
