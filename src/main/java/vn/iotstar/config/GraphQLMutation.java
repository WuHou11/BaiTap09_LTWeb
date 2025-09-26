package vn.iotstar.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import vn.iotstar.model.Category;
import vn.iotstar.model.Product;
import vn.iotstar.model.User;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.UserService;

@Controller
public class GraphQLMutation {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    // ================== PRODUCT ==================
    @MutationMapping
    public Product createProduct(@Argument String title,
                                 @Argument Double price,
                                 @Argument Integer quantity,
                                 @Argument String description,
                                 @Argument Integer userId) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescription(description);

        userService.getUserById(userId).ifPresent(product::setUser);

        return productService.saveProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id,
                                 @Argument String title,
                                 @Argument Double price,
                                 @Argument Integer quantity,
                                 @Argument String description,
                                 @Argument Integer userId) {
        Optional<Product> existing = productService.getProductById(id);
        if (existing.isPresent()) {
            Product product = existing.get();
            product.setTitle(title);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setDescription(description);

            userService.getUserById(userId).ifPresent(product::setUser);

            return productService.saveProduct(product);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        if (productService.getProductById(id).isPresent()) {
            productService.deleteProduct(id);
            return true;
        }
        return false;
    }

    // ================== CATEGORY ==================
    @MutationMapping
    public Category createCategory(@Argument String name,
                                   @Argument String images) {
        Category category = new Category();
        category.setName(name);
        category.setImages(images);
        return categoryService.saveCategory(category);
    }

    @MutationMapping
    public Category updateCategory(@Argument Integer id,
                                   @Argument String name,
                                   @Argument String images) {
        Optional<Category> existing = categoryService.getCategoryById(id);
        if (existing.isPresent()) {
            Category category = existing.get();
            category.setName(name);
            category.setImages(images);
            return categoryService.saveCategory(category);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument Integer id) {
        if (categoryService.getCategoryById(id).isPresent()) {
            categoryService.deleteCategory(id);
            return true;
        }
        return false;
    }

    // ================== USER ==================
    @MutationMapping
    public User createUser(@Argument String fullname,
                           @Argument String password,
                           @Argument String email,
                           @Argument String phone) {
        User user = new User();
        user.setFullname(fullname);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        return userService.saveUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument Integer id,
                           @Argument String fullname,
                           @Argument String password,
                           @Argument String email,
                           @Argument String phone) {
        Optional<User> existing = userService.getUserById(id);
        if (existing.isPresent()) {
            User user = existing.get();
            user.setFullname(fullname);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);
            return userService.saveUser(user);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Integer id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return true;
        }
        return false;
    }
}
