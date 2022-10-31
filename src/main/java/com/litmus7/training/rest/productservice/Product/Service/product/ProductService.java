package com.litmus7.training.rest.productservice.Product.Service.product;


import java.util.List;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public Product getProduct( int id);
	public Product createProduct(Product product);
	public ResponseDetails deleteProduct( int id);

}
