package com.example.demo.controllers;

import com.example.demo.PostTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class FormExample {

    ArrayList<String> list = new ArrayList<>();;
    // Showing how to create a form using thymeleaf
    @GetMapping(value = "/submit")
    public String renderForm() {
        return "submit";
    }

    @PostMapping(value="/new-post")
    public String renderList(@RequestParam("title") String title, @RequestParam("content") String content,
                                @RequestParam("number-of-cats") String numberOfCats, @RequestParam("date") String date,
                                @RequestParam("visibility") String visibility) {

        PostTemplate postTemplate = new PostTemplate(title,content,numberOfCats,date,visibility);
        list.add(postTemplate.toString());

        return "redirect:/dashboard";
    }

    @GetMapping(value = "/dashboard")
    @ResponseBody
    public ArrayList<String> dashboard(){
        return list;
    }
}
