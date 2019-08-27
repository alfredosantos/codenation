package com.challenge.repository;

import com.challenge.entity.Challenge;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository {

  Optional<Challenge> findById(Long id);

  Optional<Challenge> findByName(String nome);

  Optional<Challenge> findByCompanyId(Long id);
}
