package ru.vlsu.ispi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.ispi.model.ProductGroup;
import ru.vlsu.ispi.repository.ProductGroupRepository;

import java.util.List;
@Slf4j
@Service
public class ProductGroupService {
    private final ProductGroupRepository productGroupRepository;

    @Autowired
    public ProductGroupService(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }
    public List<ProductGroup> productGroupList()
    {
        return productGroupRepository.findAll();
    }
    public ProductGroup show(long id)
    {
        return productGroupRepository.findById(id).orElse(null);
    }
    public void save(ProductGroup productGroup){
        log.info("output{}", productGroup.getName());
        productGroupRepository.save(productGroup);
    }
    public void delete(long id)
    {
        log.info("delete{}", id);
        productGroupRepository.deleteById(id);
    }
}
