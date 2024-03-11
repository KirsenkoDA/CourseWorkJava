package ru.vlsu.ispi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("")
    public String index(Model model) {
        List<ProductGroup> productGroups = productGroupService.productGroupList();
        model.addAttribute("productGroups", productGroups);
        return "productGroup/index";
    }
}
