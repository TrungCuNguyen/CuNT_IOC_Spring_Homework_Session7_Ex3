package com.exercise.api.controller;

import com.exercise.api.dto.request.CandidateCreateDTO;
import com.exercise.api.dto.request.CandidateUpdateDTO;
import com.exercise.api.entity.Candidate;
import com.exercise.api.repository.CandidateRepository;
import com.exercise.api.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    private final CandidateRepository candidateRepository;
    // Thêm mới
    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@Valid @RequestBody CandidateCreateDTO request) {
        Candidate candidate = candidateService.addCandidate(request);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Candidate> updateCandidate(
            @PathVariable Long id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidate not found"));

        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        Candidate updatedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.ok(updatedCandidate); // Trả về HTTP 200 OK cùng thông tin vừa cập nhật
    }
}

