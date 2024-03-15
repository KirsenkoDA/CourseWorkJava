package ru.vlsu.ispi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.model.Product;
import ru.vlsu.ispi.model.ProductGroup;
import ru.vlsu.ispi.service.ProductGroupService;
import ru.vlsu.ispi.service.ProductService;

@RequestMapping("/products")
@Controller
public class ProductController {
    private final ProductService productService;
    private final ProductGroupService productGroupService;

    @Autowired
    public ProductController(ProductService productService, ProductGroupService productGroupService) {
        this.productService = productService;
        this.productGroupService = productGroupService;
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
        model.addAttribute("product", product);
        return "product/show";
    }
    @GetMapping("/new")
    public String newProduct(Model model)
    {
        model.addAttribute("product", new Product());
        model.addAttribute("groups", productGroupService.productGroupList());
        return "product/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("product") Product product, @PathVariable(name="poductGroup") Long productGroupId)
    {
        product.setProductGroup(productGroupService.show(productGroupId));
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
        return "product/edit.html";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("product") Product product, @PathVariable("id") Long id)
    {
        productService.save(product);
        return "redirect:/products";
    }
}
