package com.tw.demo.service;

import com.tw.demo.model.Product;
import com.tw.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> finaAll(String brand, String category, Integer minPrice, Integer maxPrice, int pageNum, int pageSize, String order) {
		return productRepository.findAll(brand, category, minPrice, maxPrice, pageNum, pageSize, order);
	}
}
