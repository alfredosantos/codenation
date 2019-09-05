package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

  @Autowired
  private AccelerationService accelerationService;

  @GetMapping
  public List<Acceleration> findByCompanyId(Long companyId) {
    return this.accelerationService.findByCompanyId(companyId);
  }

  @GetMapping
  public Optional<Acceleration> findById(Long id) {
    return this.accelerationService.findById(id);
  }

}
