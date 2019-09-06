package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  CandidateService candidateService;

  @GetMapping
  public List<CandidateDTO> findAll(@RequestParam(required = false) Long companyId,
      @RequestParam(required = false) Long accelerationId) {
    if (companyId != null) {
      return candidateService.findByCompanyId(companyId).stream().map(c -> toCandidateDTO(c))
          .collect(Collectors.toList());
    } else if (accelerationId != null) {
      return candidateService.findByAccelerationId(accelerationId).stream()
          .map(c -> toCandidateDTO(c)).collect(Collectors.toList());
    } else {
      return new ArrayList<>();
    }
  }

  @GetMapping("/{userId}/{companyId}/{accelerationId}")
  public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId,
      @PathVariable Long companyId,
      @PathVariable Long accelerationId) {
    Optional<Candidate> candidate = candidateService.findById(userId, companyId, accelerationId);
    return candidate.isPresent() ? ResponseEntity.ok(toCandidateDTO(candidate.get()))
        : ResponseEntity.ok(new CandidateDTO(userId, companyId, accelerationId, 0,
            LocalDateTime.now().toString()));
  }

  private CandidateDTO toCandidateDTO(Candidate c) {
    String createdAt = c.getCreatedAt() != null ? c.getCreatedAt().toString() : null;
    final CandidateDTO candidateDTO = new CandidateDTO(
        c.getId().getUser().getId(), c.getId().getAcceleration().getId(),
        c.getId().getCompany().getId(), c.getStatus(), createdAt
    );
    return candidateDTO;
  }
}