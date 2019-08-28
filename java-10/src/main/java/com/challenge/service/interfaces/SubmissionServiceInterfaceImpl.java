package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SubmissionServiceInterfaceImpl implements SubmissionServiceInterface {

  @Autowired
  private SubmissionRepository submissionRepository;

  @Override
  public BigDecimal findHigherScoreByChallengeId(Long challengeId) {

    return submissionRepository.findHigherScoreByChallengeId(challengeId);
  }

  @Override
  public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId,
      Long accelerationId) {
    return (List<Submission>) submissionRepository.findHigherScoreByChallengeId(challengeId);
  }

  @Override
  public Submission save(Submission object) {

    return submissionRepository.save(object);
  }
}
