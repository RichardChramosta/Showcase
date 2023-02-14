package com.example.doplereddit.repositories;

import com.example.doplereddit.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findAllById(Long id);
  // findAllByNameAndPassword(String name,String password);
  Optional<User> findByNameAndPassword(String name,String password);
}
