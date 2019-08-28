package com.challenge.repository;

import com.challenge.entity.Submission;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

  BigDecimal findHigherScoreByChallengeId(Long challengeId);

  List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}