package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import java.math.BigDecimal;
import java.util.List;

public class SubmissionServiceInterfaceImpl implements SubmissionServiceInterface {

  @Override
  public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
    return null;
  }

  @Override
  public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId,
      Long accelerationId) {
    return null;
  }

  @Override
  public Submission save(Submission object) {
    return null;
  }
}
