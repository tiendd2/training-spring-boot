package com.tiendd.bookservice.responsitory;

import com.tiendd.bookservice.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
