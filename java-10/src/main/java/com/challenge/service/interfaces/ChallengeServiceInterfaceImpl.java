package com.challenge.service.interfaces;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceInterfaceImpl implements ChallengeServiceInterface {

  @Autowired
  private ChallengeRepository challengeRepository;

  @Override
  public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
    return challengeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
  }

  @Override
  public Challenge save(Challenge object) {
    return challengeRepository.save(object);
  }
}
