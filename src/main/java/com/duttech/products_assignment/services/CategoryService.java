package com.duttech.products_assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duttech.products_assignment.models.Category;
import com.duttech.products_assignment.models.Product;
import com.duttech.products_assignment.repositories.CategoryRepository;
import com.duttech.products_assignment.repositories.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	private ProductRepository proRepo;
	
	public List<Category> allCategories(){
		return catRepo.findAll();
	}
	
	public Category createcategory(Category cat) {
		return catRepo.save(cat);
	}
	
	public Category aCategory(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public List<Category> noPro(Product product){
		return catRepo.findByProductsNotContaining(product);
			
	}
	
	public Category updateCategory(Category category) {
		return catRepo.save(category);
	}
	
}
