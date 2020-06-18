package com.controller;

import com.model.Product;
import com.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class ProductController {
    public ProductService productService = new ProductService();
    @GetMapping("/")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "index";
    }
    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect){
            product.setId((int)(Math.random()*10000));
            productService.save(product);
            redirect.addFlashAttribute("cute","Fuck you !!!");
            return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/update")
    public String update(Product product , RedirectAttributes redirect){
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("cute","Oh shit !!!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("/product/delete")
    public String remove(Product product,RedirectAttributes attributes){
        productService.remove(product.getId());
        attributes.addFlashAttribute("cute","Oh yeah !!!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public String showProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
