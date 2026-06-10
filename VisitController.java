package com.example.blog_app;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@RestController //viewが返るわけではない
public class VisitController {
    @GetMapping("/visit")
    public String visit(HttpSession session) {
        // sessionから取り出したオブジェクトをInteger型でキャストしてcount変数に入れる
        Integer count =(Integer) session.getAttribute("count"); 
        if (count == null) {
            count = 0;
        }
        count++;
        session.setAttribute("count", count);

        return "訪問回数: " + count;
    }
    
}
