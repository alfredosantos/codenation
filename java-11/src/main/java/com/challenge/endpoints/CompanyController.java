package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @GetMapping("/{id}")
  public ResponseEntity<Company> findById(@PathVariable Long id) {
    Optional<Company> company = companyService.findById(id);
    return company.isPresent() ? ResponseEntity.ok(company.get())
        : ResponseEntity.notFound().build();
  }

  @GetMapping("/acceleration/{accelerationId}")
  public List<Company> findAllByAccelerationId(@PathVariable Long accelerationId) {
    return companyService.findByAccelerationId(accelerationId);
  }

  @GetMapping("/user/{userId}")
  public List<Company> findAllByUserId(@PathVariable Long userId) {
    return companyService.findByUserId(userId);
  }
}