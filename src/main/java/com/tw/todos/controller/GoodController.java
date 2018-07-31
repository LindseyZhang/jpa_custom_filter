package com.tw.todos.controller;

import com.tw.todos.model.Good;
import com.tw.todos.repository.GoodRepository;
import com.tw.todos.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodController {

	@Autowired
	private GoodService goodService;

	@GetMapping
	public List<Good> filterByPrice(@RequestParam("maxPrice") int maxPrice,
									@RequestParam("minPrice") int minPrice,
									@RequestParam( value = "pageNum", defaultValue = "0") int pageNum,
									@RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
									@RequestParam(value = "sortByPrice", defaultValue = "ASC") String sortByPrice) {
		return goodService.filterByPriceBetween(minPrice, maxPrice, pageNum, pageSize, sortByPrice);
	}
}
