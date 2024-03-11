package ru.vlsu.ispi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.ispi.model.ProductGroup;
import ru.vlsu.ispi.repository.ProductGroupRepository;

import java.util.List;

@Service
public class ProductGroupService {
    private final ProductGroupRepository productGroupRepository;

    @Autowired
    public ProductGroupService(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }
    public List<ProductGroup> productGroupList() {
        return productGroupRepository.findAll();
    }
}
