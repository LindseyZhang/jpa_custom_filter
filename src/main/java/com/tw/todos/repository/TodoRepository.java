package com.tw.todos.repository;

import com.tw.todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update Todo set textValue = :text where id = :id")
	public Integer updateText(int id, String text);

}
