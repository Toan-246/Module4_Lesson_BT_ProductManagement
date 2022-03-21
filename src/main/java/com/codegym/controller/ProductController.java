package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ModelAndView showListProduct (){
        ModelAndView modelAndView =new ModelAndView("/product/list");
        List<Product>products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping ("/products/create")
    public ModelAndView showCreateForm (){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/products/create")
    public ModelAndView createProduct (@ModelAttribute Product product){
        productService.create(product);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping ("/products/edit/{id}")
    public ModelAndView showEditForm (@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping ("/products/edit/{id}")
    public ModelAndView editProduct (@PathVariable int id, @ModelAttribute Product product){
        productService.update(id, product);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping ("/products/delete/{id}")
    ModelAndView showDeleteForm (@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("/products/delete/{id}")
    public ModelAndView deleteProduct (@PathVariable int id){
        productService.delete(id);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping ("/products/{id}")
    public ModelAndView viewProduct (@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/product/view");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @GetMapping("products/search")
    public ModelAndView searchProductByName (@RequestParam(name = "q")String name){
        ModelAndView modelAndView = new ModelAndView("/product/view");
        Product product = productService.findProductByName(name);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
