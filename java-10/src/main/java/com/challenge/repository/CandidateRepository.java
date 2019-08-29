package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

  Optional<Candidate> findById(CandidateId id);

  @Query(value = "select * from candidate where user_id = :userId and acceleration_id = :accelerationId and company_id = :companyId", nativeQuery = true)
  Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId,
      @Param("accelerationId") Long accelerationId);

  @Query(value = "select * from candidate where company_id = :companyId", nativeQuery = true)
  List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

  @Query(value = "select * from candidate where acceleration_id = :accelerationId", nativeQuery = true)
  List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
