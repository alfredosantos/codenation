package com.challenge.repository;

import com.challenge.entity.Company;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository {

  List<Company> findByAccelerationId(Long accelerationId);

  List<Company> findByUserId(Long userId);
}
