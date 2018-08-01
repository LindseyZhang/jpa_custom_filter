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

	public List<Good> finaAll(String name, int pageNum, int pageSize, String order) {
		final Sort orders = new Sort(order.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, "price");
		final PageRequest page = PageRequest.of(pageNum, pageSize, orders);
		return goodRepository.findAll(page).getContent();
	}
}
