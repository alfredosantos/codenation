package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/acceleration")
public class AccelerationController {

  private AccelerationService accelerationService;

  @GetMapping
  public List<Acceleration> findAll(@RequestParam Long companyId) {
    return accelerationService.findByCompanyId(companyId);
  }

  @GetMapping("{id}")
  public ResponseEntity<Acceleration> findById(@PathVariable Long id) {
    Optional<Acceleration> acceleration = accelerationService.findById(id);
    return acceleration.isPresent() ? ResponseEntity.ok(acceleration.get())
        : ResponseEntity.notFound().build();
  }
}