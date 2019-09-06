package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping
  public List<User> findAll(@RequestParam(required = false) Long companyId,
      @RequestParam(required = false) String accelerationName) {
    if (companyId != null) {
      return userService.findByCompanyId(companyId);
    } else if (accelerationName != null) {
      return userService.findByAccelerationName(accelerationName);
    } else {
      return new ArrayList<User>();
    }
  }
}