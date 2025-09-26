package vn.iotstar.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import vn.iotstar.model.Category;
import vn.iotstar.model.Product;
import vn.iotstar.model.User;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.repository.UserRepository;

@Controller
public class GraphQLQuery {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // ================== PRODUCT ==================
    @QueryMapping
    public List<Product> getAllProductsSortedByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @QueryMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // ================== CATEGORY ==================
    @QueryMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @QueryMapping
    public Category getCategoryById(@Argument Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // ================== USER ==================
    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @QueryMapping
    public User getUserById(@Argument Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
