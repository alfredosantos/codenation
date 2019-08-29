package com.challenge.repository;

import com.challenge.entity.Submission;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

  @Query(value = "select max(score) from submission as sub\n" +
      "join challenge as ch on sub.challenge_id = ch.id\n" +
      "where ch.id = :challengeId", nativeQuery = true)
  BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

  @Query(value = "select sub.* from submission as sub\n" +
      "join challenge as ch on sub.challenge_id = ch.id\n" +
      "join acceleration as ac on ac.challenge_id = ch.id\n" +
      "where ac.id = :accelerationId and ch.id = :challengeId", nativeQuery = true)
  List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
      @Param("accelerationId") Long accelerationId);
}