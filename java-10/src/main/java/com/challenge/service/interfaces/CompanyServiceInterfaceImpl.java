package com.challenge.service.interfaces;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceInterfaceImpl implements CompanyServiceInterface {

  @Autowired
  private CompanyRepository companyRepository;

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
