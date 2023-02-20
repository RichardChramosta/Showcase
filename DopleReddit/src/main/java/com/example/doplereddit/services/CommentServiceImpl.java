package com.example.doplereddit.services;

import com.example.doplereddit.models.Comment;
import com.example.doplereddit.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;
  private final UserServiceImpl userService;
  private final PostServiceImpl postService;

  public CommentServiceImpl(CommentRepository commentService, UserServiceImpl userService,
      PostServiceImpl postService) {
    this.commentRepository = commentService;
    this.userService = userService;
    this.postService = postService;
  }

  @Override
  public void saveComments(Comment comment, Long userId, Long postId) {
    comment.setCommentUser(userService.findAllById(userId));
    comment.setThisPost(postService.findPostById(postId));
    commentRepository.save(comment);
  }
}
