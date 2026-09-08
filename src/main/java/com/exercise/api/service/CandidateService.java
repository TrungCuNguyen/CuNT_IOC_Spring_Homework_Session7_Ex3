package com.exercise.api.service;

import com.exercise.api.dto.request.CandidateCreateDTO;
import com.exercise.api.entity.Candidate;
import com.exercise.api.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;
    public Candidate addCandidate(CandidateCreateDTO request) {

        Candidate candidate = new Candidate();
        candidate.setAge(request.getAge());
        candidate.setEmail(request.getEmail());
        candidate.setFullName(request.getFullName());
        candidate.setYearsOfExperience(request.getYearsOfExperience());
        return candidateRepository.save(candidate);
    }
}
