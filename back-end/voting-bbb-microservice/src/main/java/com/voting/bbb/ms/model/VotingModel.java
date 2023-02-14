package com.voting.bbb.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("voting")
public class VotingModel {

    @Id
    private String id;
    private ParticipantModel participant;
    private Date dataHora;
}
