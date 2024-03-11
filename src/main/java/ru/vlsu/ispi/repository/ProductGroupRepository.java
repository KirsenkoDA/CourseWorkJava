package ru.vlsu.ispi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.ispi.model.ProductGroup;

public interface ProductGroupRepository  extends JpaRepository<ProductGroup, Long> {
}
