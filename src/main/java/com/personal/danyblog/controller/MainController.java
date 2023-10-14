package com.personal.danyblog.controller;

import com.personal.danyblog.model.BlogModel;
import com.personal.danyblog.model.titleAndId;
import com.personal.danyblog.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/omnipresentpodcast")
public class MainController {

    @Autowired
    MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping("administration/addblog")
    public ResponseEntity<BlogModel> addBlog(@RequestBody BlogModel model) {
         return mainService.addBlogModel(model);
    }

    @GetMapping("/blog")
    public List<titleAndId> getBlogTitles() {
        return mainService.getBlogTitles();
    }

    @GetMapping("/blog/post/{id}")
    public BlogModel getBlogById(@PathVariable String id) {
        return mainService.getBlogById(id);
    }

    @DeleteMapping("administration/delete/{id}")
    public ResponseEntity<?> deletePosting(@PathVariable String id) {
        return mainService.deleteBlog(id);
    }

}
