package com.challenge.service.interfaces;

import com.challenge.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterface extends ServiceInterface<User> {

  Optional<User> findById(Long userId);

  List<User> findByAccelerationName(String name);

  List<User> findByCompanyId(Long companyId);
}
