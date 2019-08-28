package com.challenge.repository;

import com.challenge.entity.Submission;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository <Submission, Long> {

  BigDecimal findHigherScoreByChallengeId(Long challengeId);
}
