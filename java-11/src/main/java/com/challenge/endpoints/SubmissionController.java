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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/submission")
public class SubmissionController {

  @Autowired
  SubmissionService submissionService;

  @GetMapping("/challenge/{challengeId}/acceleration/{accelerationId}")
  public List<SubmissionDTO> findAllByChallengeIdAndAccelerationId(@PathVariable Long challengeId,
      @PathVariable Long accelerationId) {
    List<Submission> submissions = submissionService
        .findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    return submissions.stream().map(s -> toSubmissionDTO(s)).collect(Collectors.toList());
  }

  private SubmissionDTO toSubmissionDTO(Submission s) {
    String createdAt = s.getCreatedAt() != null ? s.getCreatedAt().toString() : null;
    BigDecimal score =
        s.getScore() != null ? score = new BigDecimal(s.getScore()) : BigDecimal.ZERO;
    return new SubmissionDTO(
        s.getId().getChallenge().getId(), s.getId().getUser().getId().toString(), score, createdAt
    );
  }

  private List<SubmissionDTO> toSubmissionsDTO(List<Submission> candidates) {
    return candidates.stream().map(c -> toSubmissionDTO(c)).collect(Collectors.toList());
  }
}