package com.example.zerothweekproject.repositories;

import com.example.zerothweekproject.models.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookMarkRepo extends JpaRepository<BookMark, Long> {
    Optional<BookMark> findById(Long id);
}
