package com.challenge.service.interfaces;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceInterfaceImpl implements UserServiceInterface {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Optional<User> findById(Long userId) {
    return userRepository.findById(userId);
  }

  @Override
  public List<User> findByAccelerationName(String name) {
    return userRepository.findByAccelerationName(name);
  }

  @Override
  public List<User> findByCompanyId(Long companyId) {
    return userRepository.findByCompanyId(companyId);
  }

  @Override
  public User save(User object) {
    object.setCreatedAt(LocalDateTime.now());
    return userRepository.save(object);
  }
}