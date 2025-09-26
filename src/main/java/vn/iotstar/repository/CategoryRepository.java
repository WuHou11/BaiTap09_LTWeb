package vn.iotstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}