package com.challenge.security;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = this.userRepository.findByEmail(email);

    if (user.isPresent()) {
      return user.get();
    }
    throw new UsernameNotFoundException("Username" + user.get() + "not found.");
  }
}
