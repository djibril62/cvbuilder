package com.cvbuilder.repository;

import com.cvbuilder.model.CV;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CVRepository extends MongoRepository<CV, String> {
}
