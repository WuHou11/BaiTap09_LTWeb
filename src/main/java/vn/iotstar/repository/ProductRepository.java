package vn.iotstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Lấy tất cả product sắp xếp theo price ASC
    List<Product> findAllByOrderByPriceAsc();

    // Nếu muốn lọc theo User (vì Product có userid)
    List<Product> findByUser_Id(Integer userId);
}
