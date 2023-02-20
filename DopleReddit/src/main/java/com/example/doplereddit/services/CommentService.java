package com.example.doplereddit.services;

import com.example.doplereddit.models.Comment;

public interface CommentService {

  void saveComments(Comment comment, Long userId, Long postId);

}
