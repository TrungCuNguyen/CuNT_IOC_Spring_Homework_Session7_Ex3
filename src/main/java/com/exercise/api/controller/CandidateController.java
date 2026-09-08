package com.exercise.api.controller;

import com.exercise.api.dto.request.CandidateCreateDTO;
import com.exercise.api.entity.Candidate;
import com.exercise.api.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    // Thêm mới
    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@Valid @RequestBody CandidateCreateDTO request) {
        Candidate candidate = candidateService.addCandidate(request);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }
}
