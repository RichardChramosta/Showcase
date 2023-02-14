package com.example.doplereddit.repositories;

import com.example.doplereddit.models.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
  List<Post> findAll();
  Optional<Post> findAllById(Long id);
}
