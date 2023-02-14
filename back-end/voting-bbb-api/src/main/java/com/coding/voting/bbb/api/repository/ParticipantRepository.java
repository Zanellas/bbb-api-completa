package com.coding.voting.bbb.api.repository;

import com.coding.voting.bbb.api.model.ParticipantModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<ParticipantModel, String> {
}
