package com.litmus7.training.rest.productservice.Product.Service.product;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	

//    @Digits(message="Id must not contain decimal point", fraction = 0, integer =6)	
//	@NotBlank(message ="Id cannot be white space")
//	@Pattern(regexp = "[0-9]*")
//	@Positive 
//	@NotNull(message ="Id cannot be null")
	private Integer product_id;
	
	
	@NotNull(message ="Name cannot be null")
	@Size(min=2, message = "Product name must contain atleast 2 characters")
	@NotBlank(message ="Name cannot be white space")
	private String product_name;

}
