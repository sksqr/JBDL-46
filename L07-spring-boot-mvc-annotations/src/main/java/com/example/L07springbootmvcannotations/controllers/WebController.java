package com.example.L07springbootmvcannotations.controllers;

import com.example.L07springbootmvcannotations.models.Product;
import com.example.L07springbootmvcannotations.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WebController {


    public WebController(ProductService productService) {
        this.productService = productService;
    }

    //    @Autowired
    private ProductService productService;

    @GetMapping("/static")
    public String getStaticMenu(){
        return "static-menu.html";
    }


    @GetMapping("/js-menu")
    public String getJsMenu(){
        return "menu-with-js.html";
    }

    @GetMapping("/menu")
    public ModelAndView getMenu(){
        ModelAndView modelAndView = new ModelAndView("dynamic-menu.html");
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY hh:mm:ss");
        modelAndView.getModelMap().put("serverTime",dateFormat.format(new Date()));
        modelAndView.getModelMap().put("products",productService.getProducts());
        return modelAndView;
    }



    @GetMapping("/productList")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

}
