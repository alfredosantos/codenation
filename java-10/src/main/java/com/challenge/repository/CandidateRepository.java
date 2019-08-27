package com.challenge.repository;

import com.challenge.entity.Candidate;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository {

  Optional<Candidate> findById(Long id);

}
