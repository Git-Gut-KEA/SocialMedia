package com.example.demo.controllers;

import com.example.demo.PostTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class FormExample {

    ArrayList<PostTemplate> submits = new ArrayList<>();
    ArrayList<PostTemplate> latestSubmit = new ArrayList<>();
    // Showing how to create a form using thymeleaf
    @GetMapping(value = "/submit")
    public String renderForm() {
        return "submit";
    }

    @PostMapping(value="/new-post")
    public String renderList(@RequestParam("title") String title, @RequestParam("content") String content,
                                @RequestParam("number-of-cats") String numberOfCats, @RequestParam("date") String date,
                                @RequestParam("visibility") String visibility) {

        if(latestSubmit.size() > 0){
            latestSubmit.remove(0);
        }
        PostTemplate postTemplate = new PostTemplate(title,content,numberOfCats,date,visibility);
        submits.add(postTemplate);
        latestSubmit.add(postTemplate);

        return "redirect:/success";
    }

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping(value = "/success")
    public String success(Model model){

        model.addAttribute("submits", submits);
        model.addAttribute("latestSubmit", latestSubmit);
        return "success.html";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model){
        model.addAttribute("submits", submits);

        return "dashboard.html";
    }
}
