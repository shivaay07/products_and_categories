package com.duttech.products_assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.duttech.products_assignment.models.Category;
import com.duttech.products_assignment.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product>findAll();
	
	List<Product>findByCategoriesNotContaining(Category category);
}
