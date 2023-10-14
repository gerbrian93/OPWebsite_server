package com.personal.danyblog.dto;

import com.personal.danyblog.model.BlogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoRepo extends MongoRepository<BlogModel, String> {
    Optional<BlogModel> findTopByOrderByIdDesc();
}
