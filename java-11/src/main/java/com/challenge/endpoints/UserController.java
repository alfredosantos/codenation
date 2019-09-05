package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
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
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    Optional<User> user = userService.findById(id);
    return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
  }

  @GetMapping("/acceleration/{name}")
  public List<User> findAllByAccelerationName(@PathVariable String name) {
    return userService.findByAccelerationName(name);
  }

  @GetMapping("/company/{companyId}")
  public List<User> findByCompanyId(@PathVariable Long companyId) {
    return userService.findByCompanyId(companyId);
  }
}