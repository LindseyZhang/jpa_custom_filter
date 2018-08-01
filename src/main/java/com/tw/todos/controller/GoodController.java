package com.tw.todos.controller;

import com.tw.todos.model.Good;
import com.tw.todos.repository.GoodRepository;
import com.tw.todos.repository.GoodRepositoryImpl;
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

	@Autowired
	private GoodRepository goodRepository;

	@GetMapping
	public List<Good> finaAll(@RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
							  @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
							  @RequestParam(value = "name", defaultValue = "") String name,
							  @RequestParam(name = "order", required = false) String order) {
		return goodService.finaAll(name, pageNum, pageSize, order);
	}

	@GetMapping("/test")
	public List<Good> finaAll(@RequestParam(value = "name", required = false) String name,
							  @RequestParam(value = "minPrice", required = false) Integer minPrice,
							  @RequestParam(value = "maxPrice", required = false) Integer maxPrice) {
		return goodRepository.filter(name, maxPrice, minPrice);
	}




//
//	@GetMapping("/test")
//	public List<Good> filterByPrice(@RequestParam("maxPrice") int maxPrice,
//									@RequestParam("minPrice") int minPrice,
//									@RequestParam( value = "name", required = false) String name) {
//		return goodRepository.filterGood(null, name, maxPrice, minPrice);
//	}
}
