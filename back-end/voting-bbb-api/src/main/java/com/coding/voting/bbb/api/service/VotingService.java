package com.coding.voting.bbb.api.service;

import com.coding.voting.bbb.api.model.ParticipantModel;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotingService {

    private static final String TOPIC_VOTING = "voting";
    private final KafkaTemplate<Object, Object> template;

    public void addEvent(ParticipantModel participantModel){
        template.send(TOPIC_VOTING, participantModel);
    }
}
