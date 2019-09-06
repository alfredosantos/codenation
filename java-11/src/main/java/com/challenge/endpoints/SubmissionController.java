package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/submission")
public class SubmissionController {

  @Autowired
  SubmissionService submissionService;

  @GetMapping
  public List<SubmissionDTO> findAll(@RequestParam Long challengeId,
      @RequestParam Long accelerationId) {
    return toSubmissionsDTO(
        submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
  }

  private List<SubmissionDTO> toSubmissionsDTO(List<Submission> submissions) {
    return submissions.stream().map(c -> toSubmissionDTO(c)).collect(Collectors.toList());
  }

  private SubmissionDTO toSubmissionDTO(Submission s) {
    String createdAt = s.getCreatedAt() != null ? s.getCreatedAt().toString() : null;
    BigDecimal score =
        (s.getScore() != null) ? new BigDecimal(s.getScore()) : BigDecimal.ZERO;
    return new SubmissionDTO(
        s.getId().getChallenge().getId(), s.getId().getUser().getId().toString(), score, createdAt
    );
  }
}