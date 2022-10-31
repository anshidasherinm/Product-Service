package com.litmus7.training.rest.productservice.Product.Service.product;

import java.net.URI;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.litmus7.training.rest.productservice.Product.Service.product.exceptions.ProductNotFoundException;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Implementation : autowiring  using interface
	
	@Autowired
	private ProductService service;

	@GetMapping
	public List<Product> retriveAllProducts() {

		return this.service.getAllProducts();

	}

	@GetMapping(path = "/{product_id}")
	public Product getProduct(@PathVariable int product_id) {
		
		Product product = this.service.getProduct(product_id);
		
		logger.info("product : {}",product); 	
		
		return product;

	}
	
	

	@PostMapping
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		
		logger.info("product : {}",product); 	
		
    	Product savedProduct = this.service.createProduct(product);
    	
    	URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{product_id))}").buildAndExpand(savedProduct.getProduct_id()).toUri();//earlier used : savedProduct.getProduct_id() 
    	
    	return ResponseEntity.created(location).build();
    	
	}
	
	@DeleteMapping("/{product_id}")
	public ResponseEntity<ResponseDetails> deleteProduct(@PathVariable int product_id) {
		
		ResponseDetails response = this.service.deleteProduct(product_id);
		
		logger.info("Status for Deletion:  {}",response.getStatus());
		
		return  ResponseEntity.status(200).body(response); 
	}
	
	
}
