package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  CandidateService candidateService;

  @GetMapping("/user/{userId}/company/{companyId}/acceleration/{accelerationId}")
  public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId,
      @PathVariable Long companyId,
      @PathVariable Long accelerationId) {
    Optional<Candidate> candidate = candidateService.findById(userId, companyId, accelerationId);
    return candidate.isPresent() ? ResponseEntity.ok(toCandidateDTO(candidate.get()))
        : ResponseEntity.notFound().build();
  }

  @GetMapping("/company/{id}")
  public List<CandidateDTO> findAllByCompanyId(@PathVariable Long id) {
    List<Candidate> candidates = candidateService.findByCompanyId(id);
    return this.toCandidatesDTO(candidates);
  }

  @GetMapping("/acceleration/{id}")
  public List<CandidateDTO> findAllByAccelerationId(@PathVariable Long id) {
    List<Candidate> candidates = candidateService.findByAccelerationId(id);
    return this.toCandidatesDTO(candidates);
  }

  private CandidateDTO toCandidateDTO(Candidate c) {
    String createdAt = c.getCreatedAt() != null ? c.getCreatedAt().toString() : null;
    return new CandidateDTO(
        c.getId().getUser().getId(), c.getId().getAcceleration().getId(),
        c.getId().getCompany().getId(), c.getStatus(), createdAt
    );
  }

  private List<CandidateDTO> toCandidatesDTO(List<Candidate> candidates) {
    return candidates.stream().map(c -> toCandidateDTO(c)).collect(Collectors.toList());
  }
}