//リストの要素となるクラスを作成
package com.example.blog_app;


public class Blog {
    private int id;
    private String title;
    private String content;
    private String userName;
    private int created_at;
    private int updated_at;

    public Blog(int id,String title,String content, String userName, int created_at, int updated_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    //getter
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getUserName() {
        return userName;
    }
    public int getCreated_at() {
        return created_at;
    }
    public int getUpdated_at() {
        return updated_at;
    }
    //setter
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }
}

