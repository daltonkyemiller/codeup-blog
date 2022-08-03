package com.codeup.springblog.models;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    private long id;
    private String title;
    private String body;

    public Post() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
