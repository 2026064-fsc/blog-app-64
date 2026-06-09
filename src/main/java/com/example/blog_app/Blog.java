//リストの要素となるクラスを作成
package com.example.blog_app;


public class Blog {
    private String title;
    private String userName;

    public Blog(String title, String userName) {
        this.title = title;
        this.userName = userName;
    }
    public String getTitle() {
        return title;
    }
    public String getUserName() {
        return userName;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}

