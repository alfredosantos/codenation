package com.challenge.repository;

import com.challenge.entity.Challenge;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

  @Query(value = "select c.id, c.name, c.slug, c.created_at from challenge as c\n" +
      "join acceleration as ac on ac.challenge_id = c.id\n" +
      "join candidate as cd on cd.acceleration_id = ac.id\n" +
      "join users as us on us.id = cd.user_id\n" +
      "where us.id = :userId and ac.id = :accelerationId", nativeQuery = true)
  List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
      @Param("userId") Long userId);
}