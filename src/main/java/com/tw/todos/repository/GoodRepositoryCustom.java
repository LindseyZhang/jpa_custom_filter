package com.tw.todos.repository;

import com.tw.todos.model.Good;

import java.util.List;

public interface GoodRepositoryCustom {
	List<Good> filter(String name, Integer maxPrice, Integer minPrice);
}
