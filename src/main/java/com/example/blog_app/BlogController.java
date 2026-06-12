package com.example.blog_app;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;





// import ch.qos.logback.core.model.Model;

@Controller
public class BlogController {

    // //何も引数をとらずビュー名と一致するhtmlを表示する
    // @GetMapping("/blogs")
    // public String blog() {
    // return "blogs";
    // }

    // //DBに接続せず、自分でリストを作成
    // @GetMapping("/blogs")
    // public String blogs(Model model) {
    // List<Blog> blogs = List.of(
    // new Blog("博士の話", "松川さん")
    // );
    // model.addAttribute("blogs", blogs);
    // return "blogs";
    // }

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    //一覧
    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blogs";
    }

    @GetMapping("/")
    public String blog() {
        return "redirect:blogs";
    }
    
    @GetMapping("/blog/detail/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blogOpt.get());
        return "blog/detail";
    }

    //一件ずつ閲覧
    @PostMapping("/blogs/{id}")
    public String findById(@PathVariable Long id, @ModelAttribute BlogForm form) {
        //TODO: process POST request
        blogService.findById(id);
        
        return "redirect:/blogs/" + id;
    }
    

    

    //新しい記事を投稿（画面表示）
    @GetMapping("blog/new")
    public String addblog() {
        return "blog/new";
    }


    //フォームからの送信を受け付けるpostMappingを書く
    @PostMapping("/blogs")
    public String save(@ModelAttribute BlogForm form) {
    //TODO: process POST request
    blogService.save(form);
    return "redirect:/blogs";

    }


   

    // //削除
    // @PostMapping("/blogs/{id}/delete")
    // public String delete(@PathVariable Long id) {
    //     // TODO: process POST request
    //     blogService.deleteById(id);
    //     return "redirect:/tasks";
    // }

}
