package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    
    //一覧で表示
    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    //記事を一件ずつ個別に閲覧
    public Optional<Blog> findById(Long id){
        return blogRepository.findById(id);
    }
    //新しい記事を投稿
    public void add(Blog blog){
        blogRepository.save(new Blog(blog.getId(),blog.getTitle(),blog.getContent(),blog.getUserName(),blog.getCreated_at(),blog.getUpdated_at()));
    }
    // //削除
    // public void deleteById(Long id){
    //     blogRepository.deleteById(id);
    // }


}