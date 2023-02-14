package com.coding.voting.bbb.api.controller;

import com.coding.voting.bbb.api.model.ParticipantModel;
import com.coding.voting.bbb.api.repository.ParticipantRepository;
import com.coding.voting.bbb.api.service.VotingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/voting")
@AllArgsConstructor
@CrossOrigin
public class VotingController {

    private final VotingService votingService;
    private final ParticipantRepository participantRepository;

    @PostMapping
    public ResponseEntity<ParticipantModel> vote(@RequestBody ParticipantModel participantModel) {
        Optional<ParticipantModel> responseOpt = participantRepository.findById(participantModel.getId());
        if(responseOpt.isEmpty()){
            throw new RuntimeException("invalid[" + participantModel.getId() +      "] code for voting");
        }
        ParticipantModel response = responseOpt.get();
        votingService.addEvent(response);
        return ResponseEntity.ok(response);
    }
}
