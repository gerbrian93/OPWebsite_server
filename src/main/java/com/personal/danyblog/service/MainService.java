package com.personal.danyblog.service;

import com.personal.danyblog.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.personal.danyblog.dto.MongoRepo;
import com.personal.danyblog.model.BlogModel;
import com.personal.danyblog.model.titleAndId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MainService {


    @Autowired
    private MongoRepo mongoRepo;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    public ResponseEntity<BlogModel> addBlogModel(BlogModel model) {
        UUID id = UUID.randomUUID();
        model.setId(id.toString());
        BlogModel createdBlog = mongoRepo.save(model);
        return ResponseEntity.ok(createdBlog);
    }

//    private int getHighestId() {
//        BlogModel model = mongoRepo.findTopByOrderByIdDesc().orElse(null);
//        return model.getId();
//
//    }

    public List<titleAndId> getBlogTitles() {
        List<titleAndId> titles = new ArrayList<>();
        List<BlogModel> blogs = mongoRepo.findAll();
        blogs.forEach(model -> {
            titleAndId entity = new titleAndId(model.getTitle(), model.getId());
            titles.add(entity);
        });
        return titles;
    }

    public BlogModel getBlogById(String id) {
        return mongoRepo.findById(id).orElse(null);
    }



    public ResponseEntity<?> deleteBlog(String id) {
        try {
            if (!mongoRepo.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog post not found with ID: " + id);
            }
            mongoRepo.deleteById(id);
        } catch (IllegalArgumentException e) {
            // This is just a guess. Replace with the actual exceptions thrown by your repository.
            logger.error("Invalid ID format: {}", id, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID format: " + id);
        } catch (Exception e) {
            logger.error("Error deleting blog post with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete the blog post");
        }
            return ResponseEntity.noContent().build();  // Return 204 No Content
    }
}
