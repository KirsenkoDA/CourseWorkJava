package ru.vlsu.ispi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.ispi.model.Characteristic;
import ru.vlsu.ispi.model.Product;
import ru.vlsu.ispi.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> productList()
    {
        return productRepository.findAll();
    }
    public Product show(long id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public void save(Product product){
        productRepository.save(product);
    }
    public void delete(long id)
    {
        log.info("delete{}", id);
        productRepository.deleteById(id);
    }
}
