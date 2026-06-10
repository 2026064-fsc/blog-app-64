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
        return jdbcClient.sql("SELECT id,title,content,userName,created_at,updated_at FROM blogs")
                .query(Blog.class)
                .list();
    }

    // DBから記事を一件ずつとってくる
    public Optional<Blog> findById(Long id) {
        return jdbcClient.sql("SELECT id,title,content,userName,created_at,updated_at FROM blogs WHERE id = :id")
                .param("id", id)
                .query(Blog.class)
                .optional();
    }

    // 新しい記事を投稿する
    public void save(Blog blog) {
        jdbcClient.sql("INSERT INTO blogs(id,title,content,userName,created_at,updated_at) VALUES ")
                .param("id", blog.getId())
                .param("title", blog.getTitle())
                .param("content", blog.getContent())
                .param("userName", blog.getUserName())
                .param("created_at", blog.getCreated_at())
                .param("updated_at", blog.getUpdated_at())
                .update();
    // }
    // //発展１　idでタスクを削除するメソッド
    // public void deleteById(Long id){
    //     jdbcClient.sql("DELETE FROM tasks WHERE id = :id")
    //             .param("id",id)
    //             .update();
    // }

    // // 発展２　記事のタイトルをキーワードで検索
    // public List<Blog> searchByTitle(String keyword) {
    //     return jdbcClient.sql("SELECT id,title,content,userName,created_at,updated_at FROM blogs WHERE title LIKE :keyword")
    //             .param("keyword", "%" + keyword + "%")
    //             .query(Blog.class)
    //             .list();
     }
}
    //発展　存在しないURLにアクセスするとエラーが表示
    //発展　サイト紹介
    //発展　ログインできる
    //
