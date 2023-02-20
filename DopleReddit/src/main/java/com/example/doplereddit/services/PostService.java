package com.example.doplereddit.services;

import com.example.doplereddit.models.Post;
import com.example.doplereddit.models.User;
import java.util.List;

public interface PostService {

  List<User> readData();
  User readUser(long id);
  List<Post> findAll();
  void saveUser(User user);
  User findUser(String name, String password);
  Post findPostById(Long postId);
  void incrementUpvotes(Post post);
  void savePost(Post post, Long UserId);
}
