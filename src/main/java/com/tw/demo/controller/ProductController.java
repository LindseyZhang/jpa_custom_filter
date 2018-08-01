package com.tw.demo.controller;

import com.tw.demo.service.ProductService;
import com.tw.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> finaAll(@RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
								 @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
								 @RequestParam(value = "order", required = false, defaultValue = "ASC") String order,
								 @RequestParam(value = "brand", required = false) String brand,
								 @RequestParam(value = "category", required = false) String category,
								 @RequestParam(value = "minPrice", required = false, defaultValue = "0") Integer minPrice,
								 @RequestParam(value = "maxPrice", required = false, defaultValue = "0") Integer maxPrice) {
		return productService.finaAll(brand, category, minPrice, maxPrice, pageNum, pageSize, order);
	}

}
