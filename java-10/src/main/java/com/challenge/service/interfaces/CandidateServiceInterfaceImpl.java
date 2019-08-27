package com.challenge.service.interfaces;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidateServiceInterfaceImpl implements CandidateServiceInterface {

  @Autowired
  private CandidateRepository candidateRepository;

  @Override
  public Optional<Candidate> findById(CandidateId id) {
    return Optional.empty();
  }

  @Override
  public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
    return Optional.empty();
  }

  @Override
  public List<Candidate> findByCompanyId(Long companyId) {
    return null;
  }

  @Override
  public List<Candidate> findByAccelerationId(Long accelerationId) {
    return null;
  }

  @Override
  public Candidate save(Candidate object) {
    return null;
  }
}
