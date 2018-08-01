package com.tw.todos.repository;

import com.tw.todos.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long>, GoodRepositoryCustom {
//	List<Good> findByPriceBetween(int minPrice, int maxPrice, Pageable pageable);
}
