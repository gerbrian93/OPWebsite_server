package com.personal.danyblog.model;

import lombok.Data;

@Data
public class titleAndId {

    String title;
    String id;

    public titleAndId(String title, String id) {
        this.title = title;
        this.id = id;
    }
}
