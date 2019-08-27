package com.challenge.service.interfaces;

import com.challenge.entity.Company;
import java.util.List;
import java.util.Optional;

public class CompanyServiceInterfaceImpl implements CompanyServiceInterface {

  @Override
  public Optional<Company> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Company> findByAccelerationId(Long accelerationId) {
    return null;
  }

  @Override
  public List<Company> findByUserId(Long userId) {
    return null;
  }

  @Override
  public Company save(Company object) {
    return null;
  }
}
