package com.challenge.repository;

import com.challenge.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findById(Long userId);

  List<User> findByAccelerationName(String name);

  List<User> findByCompanyId(Long userId);
}