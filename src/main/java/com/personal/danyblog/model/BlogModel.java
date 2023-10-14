package com.personal.danyblog.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection="blogposts")
public class BlogModel {

    @Id
    private String id;
    private String title;
    private String author;
    private String date;
    private String body;
    private String imglink;
    private String height;
    private String width;


    public BlogModel(String id, String title, String author, String date, String body, String imglink, String height, String width) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.body = body;
        this.imglink = imglink;
        this.height = height;
        this.width = width;
    }

    public BlogModel() {

    }
}