package com.example.demo;

public class PostTemplate {
    private String title;
    private String content;
    private String numberOfCats;
    private String date;
    private String visibility;

    public PostTemplate(String title, String content, String numberOfCats, String date, String visibility){
        this.title = title;
        this.content =content;
        this.numberOfCats = numberOfCats;
        this.date = date;
        this.visibility = visibility;
    }


    @Override
    public String toString(){
        return title + ","+
                content + ","+
                numberOfCats + "," +
                date + "," +
                visibility + ",";
    }


}
