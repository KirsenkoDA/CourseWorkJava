package ru.vlsu.ispi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.ispi.model.Characteristic;
import ru.vlsu.ispi.model.Product;
import ru.vlsu.ispi.repository.CharacteristicRepository;

import java.util.List;
@Slf4j
@Service
public class CharacteristicService {
    private final CharacteristicRepository characteristicRepository;
    @Autowired
    public CharacteristicService(CharacteristicRepository characteristicRepository) {
        this.characteristicRepository = characteristicRepository;
    }

    public List<Characteristic> findByProduct(Product product){
        return characteristicRepository.findAllByProductsOrderByName(product);
    }
    public List<Characteristic> characteristicList()
    {
        return characteristicRepository.findAll();
    }
    public void save(Characteristic characteristic)
    {
        characteristicRepository.save(characteristic);
    }
}
