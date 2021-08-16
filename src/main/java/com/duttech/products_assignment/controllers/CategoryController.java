package com.duttech.products_assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duttech.products_assignment.models.Category;
import com.duttech.products_assignment.models.Product;
import com.duttech.products_assignment.services.CategoryService;
import com.duttech.products_assignment.services.ProductService;

@Controller
public class CategoryController {
	private final ProductService proServe;
	private final CategoryService catServe;
	public CategoryController(ProductService proServe, CategoryService catServe) {
		this.proServe = proServe;
		this.catServe = catServe;
	}
	
//	@Autowired
//	private CategoryService catServe;
//	private ProductService proServe;
	
	@GetMapping("/categories/new")
	public String categoryIndex(@ModelAttribute Category category) {
		return "/categories/category.jsp";
	}
	@PostMapping(path="/new/category")
	public String createCategory(@Valid @ModelAttribute Category category,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/category.jsp";
		}else {
			catServe.createcategory(category);
			return "redirect:/categories/new";
		}
	}
	@GetMapping("/category/{id}")
	public String showCategories(@PathVariable("id") Long id, Model model) {
		Category categoryShowingOnPage = catServe.aCategory(id);
		List<Product>catWithPro = proServe.noCat(categoryShowingOnPage);
		model.addAttribute("categoryShowingOnPage", categoryShowingOnPage);
		model.addAttribute("catWithPro", catWithPro);
		return "/categories/show.jsp";
		
	}
	@PostMapping(path="/create/product/{id}")
	public String productDropDown(@PathVariable("id") Long id, @RequestParam("addProduct") Long productId) {
		Category catergoryToBeUpdated = catServe.aCategory(id);
		List<Product> productListOfUpdatedCategory = catergoryToBeUpdated.getProducts();
		Product productAddsToUpdatedCategory= proServe.aProduct(productId);
		productListOfUpdatedCategory.add(productAddsToUpdatedCategory);
		catergoryToBeUpdated.setProducts(productListOfUpdatedCategory);
		catServe.updateCategory(catergoryToBeUpdated);
		return "redirect:/category/"+id;
	}
	
}
