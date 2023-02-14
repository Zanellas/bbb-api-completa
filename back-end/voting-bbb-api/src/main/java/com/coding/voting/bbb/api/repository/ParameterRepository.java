package com.coding.voting.bbb.api.repository;

import com.coding.voting.bbb.api.model.ParameterModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParameterRepository extends MongoRepository<ParameterModel, String> {
}
