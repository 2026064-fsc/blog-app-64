package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BlogController {
    @GetMapping("/blogs")
    public String blog() {
        return "blogs";
    }
    @PostMapping("/blogs")
    public String blog(@RequestParam String ) {
        //TODO: process POST request
        model.addAttribute();
        return    ;
        
    }
    

}
