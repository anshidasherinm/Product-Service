package com.litmus7.training.rest.productservice.Product.Service.product;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseDetails {
	
	private LocalDateTime timestamp;
	private String status;
	private String details;
	
}
