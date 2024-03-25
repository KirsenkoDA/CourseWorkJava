package ru.vlsu.ispi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.dto.CreateProductDTO;
import ru.vlsu.ispi.model.Characteristic;
import ru.vlsu.ispi.model.Product;
import ru.vlsu.ispi.service.CharacteristicService;
import ru.vlsu.ispi.service.ProductService;

@RequestMapping("/characteristics")
@Controller
public class CharacteristicController {
    private final CharacteristicService characteristicService;
    private final ProductService productService;
    @Autowired
    public CharacteristicController(CharacteristicService characteristicService, ProductService productService) {
        this.characteristicService = characteristicService;
        this.productService = productService;
    }
    @GetMapping("/findByProduct/{id}")
    public String findByProduct(Model model, @PathVariable Long id)
    {
        model.addAttribute("characteristics", characteristicService.findByProduct(productService.show(id)));
        return "characteristic/lab3";
    }
    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("products", characteristicService.characteristicList());
        return "characteristic/index";
    }
    @GetMapping("/new")
    public String newCharacteristic(Model model)
    {
        model.addAttribute("characteristic", new Characteristic());
        return "characteristic/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("characteristic") Characteristic newCharacteristic)
    {
        Characteristic characteristic = new Characteristic();
        characteristic.setName(newCharacteristic.getName());
        characteristicService.save(characteristic);
        return "redirect:/characteristics";
    }
}
