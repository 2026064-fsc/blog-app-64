package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;



// import ch.qos.logback.core.model.Model;



@Controller
public class BlogController {

    // //何も引数をとらずビュー名と一致するhtmlを表示する
    // @GetMapping("/blogs")
    // public String blog() {
    //     return "blogs";
    // }

    // //DBに接続せず、自分でリストを作成
    // @GetMapping("/blogs")
    // public String blogs(Model model) {
    //     List<Blog> blogs = List.of(
    //         new Blog("博士の話", "松川さん")
    //     );
    //     model.addAttribute("blogs", blogs);
    //     return "blogs";
    // }
    
   
    private final BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blogs";
    }

    // @PostMapping("/blogs")
    // public String blogs(@ModelAttribute BlogForm form) {
    //     //TODO: process POST request
    //     blogService.add(form);
    //     return "redirect:/blogs";
        
    // }
    

}
