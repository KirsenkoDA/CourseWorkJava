package ru.vlsu.ispi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.ispi.model.Characteristic;
import ru.vlsu.ispi.model.Product;

import java.util.List;
@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
    List<Characteristic> findAllByProductsOrderByName(Product product);
}
