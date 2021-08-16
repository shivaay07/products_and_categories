package com.duttech.products_assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duttech.products_assignment.models.Category;
import com.duttech.products_assignment.models.Product;
import com.duttech.products_assignment.services.CategoryService;
import com.duttech.products_assignment.services.ProductService;

@Controller
public class ProductController {
	private final ProductService proServe;
	private final CategoryService catServe;
	public ProductController(ProductService proServe, CategoryService catServe) {
		this.proServe = proServe;
		this.catServe = catServe;
	}
	
//@Autowired
//	private CategoryService catServe;
//	private ProductService proServe;
	
	@GetMapping("/products/new")
	public String productIndex(@ModelAttribute Product product) {
		return "/products/product.jsp";
	}
	@PostMapping(path="/new/product")
	public String createProduct(@Valid @ModelAttribute Product product,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/products/product.jsp";
		}else {
			proServe.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	
	@RequestMapping("/product/{id}")
	public String prodWithid(@PathVariable("id") Long id, Model model) {
		Product singleProd = proServe.aProduct(id);
		
		List<Category>prodWithCat = catServe.noPro(singleProd);
		model.addAttribute("prodWithCat", prodWithCat);
		model.addAttribute("singleProd", singleProd);
		return "/products/show.jsp";
	}
	
	@PostMapping(path="/add/category/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("addedCategory") Long categoryId) {
			Product productToBeUpdated = proServe.aProduct(id);
			List<Category> categoriesOfProduct = productToBeUpdated.getCategories();
			Category categoryAddedToProduct = catServe.aCategory(categoryId);
			categoriesOfProduct.add(categoryAddedToProduct);
			productToBeUpdated.setCategories(categoriesOfProduct);
			proServe.updateProduct(productToBeUpdated);
			return "redirect:/product/"+id;
		}
	}
	
