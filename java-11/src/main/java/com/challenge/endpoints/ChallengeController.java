package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/challenge")
public class ChallengeController {

  @Autowired
  ChallengeService challengeService;

  @GetMapping
  public List<Challenge> findAll(@RequestParam Long accelerationId, @RequestParam Long userId) {
    return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
  }
}