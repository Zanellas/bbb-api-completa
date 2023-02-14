package com.coding.voting.bbb.api.controller;

import com.coding.voting.bbb.api.model.ParameterModel;
import com.coding.voting.bbb.api.repository.ParameterRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
@AllArgsConstructor
public class ParameterController {

    private final ParameterRepository parameterRepository;

    @PostMapping("/save")
    public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameterModel) {
        ParameterModel entity = parameterRepository.save(parameterModel);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/query")
    public ResponseEntity<ParameterModel> query(@RequestParam String key) {
        Optional<ParameterModel> optParameter = parameterRepository.findById(key);
        if (optParameter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optParameter.get());
    }


}
