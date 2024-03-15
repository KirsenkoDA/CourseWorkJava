package ru.vlsu.ispi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.model.ProductGroup;
import ru.vlsu.ispi.service.ProductGroupService;

import java.util.List;
@RequestMapping("/productGroups")
@Controller
public class ProductGroupController {
    private final ProductGroupService productGroupService;
    @Autowired
    public ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }
    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("productGroups", productGroupService.productGroupList());
        return "productGroup/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model )
    {
        ProductGroup productGroup = productGroupService.show(id);
        model.addAttribute("productGroup", productGroup);
        return "productGroup/show";
    }
    @GetMapping("/new")
    public String newGroup(Model model)
    {
        model.addAttribute("productGroup", new ProductGroup());
        return "productGroup/new.html";
    }

    @PostMapping()
    public String create(@ModelAttribute("productGroup") ProductGroup productGroup)
    {
        productGroupService.save(productGroup);
        return "redirect:/productGroups";
    }
    @PostMapping ("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        productGroupService.delete(id);
        return "redirect:/productGroups";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id)
    {
        model.addAttribute("productGroup", productGroupService.show(id));
        return "productGroup/edit.html";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("productGroup") ProductGroup productGroup, @PathVariable("id") Long id)
    {
        productGroupService.save(productGroup);
        return "redirect:/productGroups";
    }
}
