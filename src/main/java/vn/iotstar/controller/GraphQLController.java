package vn.iotstar.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import vn.iotstar.model.Product;
import vn.iotstar.model.Category;
import vn.iotstar.model.User;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {

//	private final ProductService productService;
//	private final CategoryService categoryService;
//	private final UserService userService;
//
//	public GraphQLController(ProductService productService, CategoryService categoryService, UserService userService) {
//		this.productService = productService;
//		this.categoryService = categoryService;
//		this.userService = userService;
//	}
//
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
//
//	// ================== PRODUCT ==================
//	@QueryMapping
//	public List<Product> getAllProductsSortedByPrice() {
//		return productService.getAllProductsSortedByPrice();
//	}
//
//	@QueryMapping
//	public List<Product> getAllProducts() {
//		return productService.getAllProducts();
//	}
//
//	@QueryMapping
//	public Optional<Product> getProductById(@Argument Long id) {
//	    return productService.getProductById(id);
//	}
//
//	@MutationMapping
//	public Product createProduct(@Argument String title,
//	                             @Argument double price,
//	                             @Argument String description,
//	                             @Argument Integer quantity) {
//	    Product product = new Product();
//	    product.setTitle(title);
//	    product.setPrice(price);
//	    product.setDescription(description);
//	    product.setQuantity(quantity);
//	    return productService.saveProduct(product);
//	}
//
//	@MutationMapping
//	public Product updateProduct(@Argument Long id,
//	                             @Argument String title,
//	                             @Argument double price,
//	                             @Argument String description,
//	                             @Argument Integer quantity) {
//	    Optional<Product> existing = productService.getProductById(id);
//	    if (existing.isPresent()) {
//	        Product product = existing.get();
//	        product.setTitle(title);
//	        product.setPrice(price);
//	        product.setDescription(description);
//	        product.setQuantity(quantity);
//	        return productService.saveProduct(product);
//	    }
//	    return null;
//	}
//
//	@MutationMapping
//	public Boolean deleteProduct(@Argument Long id) {
//	    productService.deleteProduct(id);
//	    return true;
//	}
//
//	// ================== CATEGORY ==================
//	@QueryMapping
//	public List<Category> getAllCategories() {
//		return categoryService.getAllCategories();
//	}
//
//	@QueryMapping
//	public Optional<Category> getCategoryById(@Argument Integer id) {
//		return categoryService.getCategoryById(id);
//	}
//
//	@MutationMapping
//	public Category createCategory(@Argument String name, @Argument String images) {
//		Category category = new Category();
//		category.setName(name);
//		category.setImages(images);
//		return categoryService.saveCategory(category);
//	}
//
//	@MutationMapping
//	public Category updateCategory(@Argument Integer id, @Argument String name, @Argument String images) {
//		Optional<Category> existing = categoryService.getCategoryById(id);
//		if (existing.isPresent()) {
//			Category category = existing.get();
//			category.setName(name);
//			category.setImages(images);
//			return categoryService.saveCategory(category);
//		}
//		return null;
//	}
//
//	@MutationMapping
//	public Boolean deleteCategory(@Argument Integer id) {
//		categoryService.deleteCategory(id);
//		return true;
//	}
//
//	// ================== USER ==================
//	@QueryMapping
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
//
//	@QueryMapping
//	public Optional<User> getUserById(@Argument Integer id) {
//		return userService.getUserById(id);
//	}
//
//	@MutationMapping
//	public User createUser(@Argument String fullname, @Argument String password, @Argument String email) {
//		User user = new User();
//		user.setFullname(fullname);
//		user.setPassword(password);
//		user.setEmail(email);
//		return userService.saveUser(user);
//	}
//
//	@MutationMapping
//	public User updateUser(@Argument Integer id, @Argument String fullname, @Argument String password,
//			@Argument String email) {
//		Optional<User> existing = userService.getUserById(id);
//		if (existing.isPresent()) {
//			User user = existing.get();
//			user.setFullname(fullname);
//			user.setPassword(password);
//			user.setEmail(email);
//			return userService.saveUser(user);
//		}
//		return null;
//	}
//
//	@MutationMapping
//	public Boolean deleteUser(@Argument Integer id) {
//		userService.deleteUser(id);
//		return true;
//	}
}
