package com.example.doplereddit.services;

import com.example.doplereddit.models.Post;
import com.example.doplereddit.models.User;
import com.example.doplereddit.repositories.PostRepository;
import com.example.doplereddit.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final UserServiceImpl userService;


  public PostServiceImpl(UserRepository userRepository, PostRepository postRepository,
      UserServiceImpl userService) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.userService = userService;
  }

  @Override
  public List<User> readData() {

    return userRepository.findAll();
  }

  @Override
  public User readUser(long id) {
    Optional<User> optional = userRepository.findAllById(id);
    return optional.get();
  }

  @Override
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public Optional<User> findUser(String name, String password) {

    Optional<User> optional = userRepository.findByNameAndPassword(name, password);
    return optional;
  }

  @Override
  public Post findPostById(Long postId) {
    Optional<Post> optional = postRepository.findAllById(postId);

    return optional.get();
  }

  @Override
  public void incrementUpvotes(Post post) {
    postRepository.save(post);
  }

  @Override
  public void savePost(Post post, Long UserId) {
    post.setPostuser(userService.findAllById(UserId));
    postRepository.save(post);
  }

  @Override
  public List<Post> fivePosts(int i) {
    List<Post> allPosts = findAll();
    for (int j = 0; j < allPosts.size(); j++) {
      List<Post> outputPosts = new ArrayList<>();
      for (int k = 0; k < 5; k++) {
        outputPosts.add(allPosts.get((j*5)+k));
        if (k+1 + (j*5) > allPosts.size()) {
          break;
        }
      }
      if (i == j) {
        return outputPosts;
      }
    }
    return null;
  }
  @Override
  public List<Post> fivePosts2(Integer i) {
    List<Post> allPosts = findAll();
    for (int j = 0; j < allPosts.size(); j++) {
      List<Post> outputPosts = new ArrayList<>();
      for (int k = 0; k < 5; k++) {
        outputPosts.add(allPosts.get((j*5)+k));
        if (k+1 + (j*5) >= allPosts.size()) {
          break;
        }
      }
      if ((i-1) == j) {
        return outputPosts;
      }
    }
    return null;
  }
  @Override
  public List<Integer> countPosts() {
    List<Post> allPosts = findAll();
    int sum = 0;
    for (Post post: allPosts) {
      sum++;
    }
    List<Integer> pages = new ArrayList<>();
    for (int i = 0; i < (sum/5); i++) {
      pages.add(i+1);
    }
    return pages;
  }

  @Override
  public Integer postPage(Long postId) {
    List<Post> allPosts = findAll();
    for (int i = 1; i < (allPosts.size() / 5) + 1; i++) {
      for (int k = 0; k < 5; k++) {
        if (allPosts.get(((i-1) * 5) + k).getId() == postId) {
          return i;
        }
      }
    }
    return 1;
  }
}
