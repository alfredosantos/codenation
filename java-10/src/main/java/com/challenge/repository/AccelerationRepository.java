package com.challenge.repository;

import com.challenge.entity.Acceleration;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

  Optional<Acceleration> findById(Long id);

  Optional<Acceleration> findByName(String name);

  List<Acceleration> findByCompanyId(Long companyId);

}