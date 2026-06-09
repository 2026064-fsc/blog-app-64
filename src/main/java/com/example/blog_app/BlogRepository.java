package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {

    private final JdbcClient jdbcClient;

    // コンストラクタ注入（Springが自動で入れ込んでくれる
    public BlogRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // データベースからブログ一覧をとってくる
    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id,title,content, created_at FROM blogs")
                .query(Blog.class)
                .list();
    }

    // DBから記事を一件ずつとってくる
    public Optional<Blog> findById(Long id){
        return jdbcClient.sql("SELECT id, title, content, created_at FROM blogs WHERE id = :id")
                .param("id", id)
                .query(Blog.class)
                .optional();
    }
    //新しい記事を投稿する
    public void save(Blog blog){
        jdbcClient.sql("INSERT INTO blogs(title,content,created_at) VALUES ")
                .param("title",blog.getTitle())
                .param("content",blog.getContent())
                .param("created_at",blog.getCreated_at())
                .update();
    }
    //記事のタイトルをキーワードで検索
    public List<Blog> searchByTitle(String keyword){
        return jdbcClient.sql("SELECT title,content,created_at FROM blogs WHERE title LIKE :keyword")
                .param("keyword", "%" + keyword + "%")
                .query(Blog.class)
                .list();
    }  

}
