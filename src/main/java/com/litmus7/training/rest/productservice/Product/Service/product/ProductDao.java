package com.litmus7.training.rest.productservice.Product.Service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static int productsCount = 3;

	private static List<Product> products = new ArrayList<>();

	static {

		products.add(new Product(1, "Television"));
		products.add(new Product(2, "Mobile Phone"));
		products.add(new Product(3, "Laptop"));

	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProductById(int id) {

		Predicate<? super Product> predicate = Product -> Product.getProduct_id() == id;

		// logger.info("Printing {} ,{}",

		return products.stream().filter(predicate).findFirst().orElse(null);

	}

	public Product save(Product product) {

		product.setProduct_id(++productsCount);

		boolean status =products.add(product);

		return product;
	}

	public boolean deleteById(int id) {

		Predicate<? super Product> predicate = Product -> Product.getProduct_id()== id;

		boolean status = products.removeIf(predicate);

		return status;

	}
}
