package com.voting.bbb.ms.repository;

import com.voting.bbb.ms.model.VotingModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotingRepository extends MongoRepository<VotingModel, String> {
}
