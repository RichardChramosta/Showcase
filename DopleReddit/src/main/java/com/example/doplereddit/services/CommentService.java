package com.example.doplereddit.services;

import com.example.doplereddit.models.Comment;
import java.util.List;

public interface CommentService {

  void saveComments(Comment comment, Long userId, Long postId);
  List<Comment> findTheComments(Long postId);

}
