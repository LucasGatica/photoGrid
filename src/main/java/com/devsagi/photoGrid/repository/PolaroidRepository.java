package com.devsagi.photoGrid.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.devsagi.photoGrid.model.Polaroid;

public interface PolaroidRepository extends ReactiveMongoRepository<Polaroid, String> {

}
