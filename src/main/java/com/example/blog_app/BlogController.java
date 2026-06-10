package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
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



    // @PostMapping("/blogs")
    // public String blogs(@ModelAttribute BlogForm form) {
    // //TODO: process POST request
    // blogService.add(form);
    // return "redirect:/blogs";

    // }

    //新しい記事を投稿（画面表示）
    @GetMapping("/new")
    public String addblog() {
        return "blogs/new";
    }

    // //保存処理
    // @PostMapping("/new")
    // public String addBlog(@RequestBody String ) {
    //     //TODO: process POST request
        
    //     return entity;
    // }
    
   

    // //削除
    // @PostMapping("/tasks/{id}/delete")
    // public String delete(@PathVariable Long id) {
    //     // TODO: process POST request
    //     blogService.deleteById(id);
    //     return "redirect:/tasks";
    // }

}
