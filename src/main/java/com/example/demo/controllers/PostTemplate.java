package com.example.demo.controllers;

public class PostTemplate {
    public String title;
    public String content;
    public String numberOfCats;
    public String date;
    public String visibility;

    public PostTemplate(String title, String content, String numberOfCats, String date, String visibility){
        this.title = title;
        this.content =content;
        this.numberOfCats = numberOfCats;
        this.date = date;
        this.visibility = visibility;
    }

}
