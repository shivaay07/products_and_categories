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
public class ProductService {
	
	private final ProductRepository proRepo;
	private final CategoryRepository catRepo; 
	public ProductService(ProductRepository proRepo, CategoryRepository catRepo) {
		this.proRepo = proRepo;
		this.catRepo = catRepo;
	}
	
	@Autowired
//	private ProductRepository proRepo;
	


	
	public List<Product> allProducts(){
		return proRepo.findAll();
	}
	
	public Product createProduct(Product prod) {
		return proRepo.save(prod);
	}
	
	public Product aProduct(Long id) {
		Optional<Product> optionalProd = proRepo.findById(id);
		if(optionalProd.isPresent()) {
			return optionalProd.get();
		}else {
			return null;
		}
	}
	
//	public List<Category> prodOfCat(Long id){
//		return aProduct(id).getCategories();
//	}
	
	public List<Product> noCat(Category category){
		return proRepo.findByCategoriesNotContaining(category);
	}
	
	
	public Product updateProduct(Product product) {
		return proRepo.save(product);
	}

	
}


			


