package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/acceleration")
public class AccelerationController {

  private AccelerationService accelerationService;

  @GetMapping("/company/{companyId}")
  public List findAll(@PathParam("id") Long companyId) {
    return this.accelerationService.findByCompanyId(companyId);
  }

  @GetMapping("{id}")
  public Optional<Acceleration> findById(Long id) {
    return this.accelerationService.findById(id);
  }
}