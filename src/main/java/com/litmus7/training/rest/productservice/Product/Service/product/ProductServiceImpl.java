package com.litmus7.training.rest.productservice.Product.Service.product;

import java.time.LocalDateTime;
import static com.litmus7.training.rest.productservice.Product.Service.constants.Constant.*;
import java.util.List;

import org.springframework.stereotype.Service;

import com.litmus7.training.rest.productservice.Product.Service.product.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao daoObject = new ProductDao();

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return daoObject.getAllProducts();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product product = daoObject.getProductById(id);
		if (product == null)
			throw new ProductNotFoundException("id : " + id);
		return product;
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		Product savedproduct = daoObject.save(product);
		return savedproduct;
	}

	@Override
	public ResponseDetails deleteProduct(int id) {
		// TODO Auto-generated method stub
		boolean status = daoObject.deleteById(id);
		if (status == false) {
			throw new ProductNotFoundException("id : " + id);
		} else {
			ResponseDetails response = new ResponseDetails(LocalDateTime.now(), SUCCESS_STATUS,
					SUCCESS_DETAILS);
			return response;
		}

	}

}
