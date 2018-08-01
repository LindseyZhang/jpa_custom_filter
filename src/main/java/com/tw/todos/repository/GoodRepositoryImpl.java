package com.tw.todos.repository;

import com.tw.todos.model.Good;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

//@Repository
public class GoodRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Good> filterGood(String brand, String name, int maxPrice, int minPrice) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Good> query = criteriaBuilder.createQuery(Good.class);
		final Root<Good> goodRoot = query.from(Good.class);

		Predicate predicate = criteriaBuilder.conjunction();

		if (brand != null && !brand.isEmpty()) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(goodRoot.get("brand"), brand));
		}
		if (name != null && !name.isEmpty()) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(goodRoot.get("name"), name));
		}
		if (maxPrice != 0) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThan(goodRoot.get("price"), maxPrice));
		}
		if (minPrice != 0) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThan(goodRoot.get("price"), minPrice));
		}

		return entityManager.createQuery(query.where(predicate)).getResultList();
	}

	public List<Good> filter(String name, Integer maxPrice, Integer minPrice) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Good> query = criteriaBuilder.createQuery(Good.class);
		final Root<Good> goodRoot = query.from(Good.class);

		Predicate predicate = criteriaBuilder.conjunction();
		if (name != null && !name.isEmpty()) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(goodRoot.get("name"), name));
		}
		if (maxPrice != null ) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThan(goodRoot.get("price"), maxPrice));
		}
		if (minPrice != null) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThan(goodRoot.get("price"), minPrice));
		}


		final CriteriaQuery<Good> condition = query.where(predicate);
		return entityManager.createQuery(condition).getResultList();
	}


}
