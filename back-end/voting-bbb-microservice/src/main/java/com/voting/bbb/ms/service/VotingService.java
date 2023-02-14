package com.voting.bbb.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.voting.bbb.ms.model.ParticipantModel;
import com.voting.bbb.ms.model.VotingModel;
import com.voting.bbb.ms.repository.VotingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotingService {

    private final VotingRepository votingRepository;

    @KafkaListener(topics = "voting", groupId = "MSVoting")
    private void execute(ConsumerRecord<String, String> register) {

        String participantStr = register.value();
        log.info("Voto recebido = {}", participantStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipantModel participantModel = null;

        try {
            participantModel = mapper.readValue(participantStr, ParticipantModel.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter voto [{}]", participantStr, ex);
            return;
        }


        VotingModel votingModel = new VotingModel(null, participantModel, new Date());
        VotingModel entity = votingRepository.save(votingModel);

        log.info("Voto Registrado com sucesso [id={}, dataHora={}]", entity.getId(), entity.getDataHora());
    }
}
