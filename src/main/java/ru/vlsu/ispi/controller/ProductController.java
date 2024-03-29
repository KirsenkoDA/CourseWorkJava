package ru.vlsu.ispi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.dto.CreateProductDTO;
import ru.vlsu.ispi.dto.EditProductDTO;
import ru.vlsu.ispi.model.Characteristic;
import ru.vlsu.ispi.model.Product;
import ru.vlsu.ispi.service.CharacteristicService;
import ru.vlsu.ispi.service.ProductGroupService;
import ru.vlsu.ispi.service.ProductService;

import java.util.Set;

@RequestMapping("/products")
@Controller
public class ProductController {
    private final ProductService productService;
    private final ProductGroupService productGroupService;
    private final CharacteristicService characteristicService;

    @Autowired
    public ProductController(ProductService productService, ProductGroupService productGroupService, CharacteristicService characteristicService) {
        this.productService = productService;
        this.productGroupService = productGroupService;
        this.characteristicService = characteristicService;
    }

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("products", productService.productList());
        return "product/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model )
    {
        Product product = productService.show(id);
        model.addAttribute("productGroup", productGroupService.show(product.getProductGroup().getId()));
        model.addAttribute("product", product);
        return "product/show";
    }
    @GetMapping("/new")
    public String newProduct(Model model)
    {
        model.addAttribute("createProductDTO", new CreateProductDTO());
        model.addAttribute("groups", productGroupService.productGroupList());
        return "product/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("product") CreateProductDTO createProductDTO)
    {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setProductGroup(productGroupService.show(createProductDTO.getGroupId()));
        productService.save(product);
        return "redirect:/products";
    }
    @PostMapping ("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        productService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id)
    {
        model.addAttribute("product", productService.show(id));
        model.addAttribute("groups", productGroupService.productGroupList());
        model.addAttribute("characteristics", characteristicService.characteristicList());
        return "product/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("editProductDTO") EditProductDTO editProductDTO)
    {
        Product product = new Product();
        product.setId(editProductDTO.getId());
        product.setName(editProductDTO.getName());
        product.setCharacteristics((Set<Characteristic>) editProductDTO.getCharacteristicList());
        product.setProductGroup(productGroupService.show(editProductDTO.getGroupId()));
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/navbar")
    public String navbar()
    {
        return "parts/navbar";
    }

}
