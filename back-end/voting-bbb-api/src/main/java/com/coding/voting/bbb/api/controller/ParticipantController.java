package com.coding.voting.bbb.api.controller;

import com.coding.voting.bbb.api.model.ParticipantModel;
import com.coding.voting.bbb.api.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
@AllArgsConstructor
@CrossOrigin
public class ParticipantController {

    private final ParticipantRepository participantRepository;

    @PostMapping("/save")
    public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel participantModel) {
        ParticipantModel entity = participantRepository.save(participantModel);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/query")
    public ResponseEntity<ParticipantModel> query(@RequestParam String id) {
        Optional<ParticipantModel> optParameter = participantRepository.findById(id);
        if (optParameter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optParameter.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParticipantModel>> all() {
        List<ParticipantModel> list = participantRepository.findAll();
        return ResponseEntity.ok(list   );
    }


}
