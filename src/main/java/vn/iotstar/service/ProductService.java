package vn.iotstar.service;

import org.springframework.stereotype.Service;
import vn.iotstar.model.Product;
import vn.iotstar.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CRUD Product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Các chức năng đặc biệt
    public List<Product> getAllProductsSortedByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    public List<Product> getProductsByUserId(Integer userId) {
        return productRepository.findByUser_Id(userId);
    }
}
