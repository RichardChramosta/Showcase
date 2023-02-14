package com.example.doplereddit.services;

import com.example.doplereddit.models.User;
import com.example.doplereddit.repositories.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public User findAllById(Long userId) {
    Optional<User> user= userRepository.findAllById(userId);

    return user.get();
  }
}
