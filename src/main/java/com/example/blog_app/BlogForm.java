package com.example.blog_app;

public class BlogForm {
    private String title;
    private String content;
    private String userName;
    private Integer created_at;

    public BlogForm(String title, String content, String userName, Integer created_at) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.created_at = created_at;
    }

    // getter
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getCreated_at() {
        return created_at;
    }
    // setter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }
}
