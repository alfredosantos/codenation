package com.challenge.repository;

import com.challenge.entity.Candidate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository {

  Optional<Candidate> findById(Long id);

  Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

  List<Candidate> findByCompanyId(Long companyId);

  List<Candidate> findByAccelerationId(Long accelerationId);
}
