package com.tw.demo.repository;

import com.tw.demo.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
	List<Product> findAll(String brand, String category, Integer minPrice, Integer maxPrice, int pageNum, int pageSize, String order);
}
