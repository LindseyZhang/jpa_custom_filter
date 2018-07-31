package com.tw.todos.service;

import com.tw.todos.model.Good;
import com.tw.todos.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
	@Autowired
	private GoodRepository goodRepository;


	public List<Good> filterByPriceBetween(int minPrice, int maxPrice, int pageNum, int pageSize, String sortByPrice) {
		final Sort orders = new Sort(sortByPrice.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, "price");
		return goodRepository.findByPriceBetween(minPrice, maxPrice, new PageRequest(pageNum, pageSize, orders));
	}
}
