package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SubmissionServiceInterface extends ServiceInterface<Submission> {

  BigDecimal findHigherScoreByChallengeId(Long challengeId);

  List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
