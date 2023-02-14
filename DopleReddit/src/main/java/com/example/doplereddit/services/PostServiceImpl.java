package com.example.doplereddit.services;

import com.example.doplereddit.models.Post;
import com.example.doplereddit.models.User;
import com.example.doplereddit.repositories.PostRepository;
import com.example.doplereddit.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final UserServiceImpl userService;


  public PostServiceImpl(UserRepository userRepository, PostRepository postRepository,UserServiceImpl userService) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.userService =userService;
  }
  @Override
  public List<User> readData() {

    return userRepository.findAll();
  }
  public User readUser(long id) {

    Optional<User> optional = userRepository.findAllById(id);
    return optional.get();
  }

  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public User findUser(String name,String password) {


    Optional<User> optional = userRepository.findByNameAndPassword(name,password);
    return optional.get();
  }

  public Post findPostById(Long postId) {
    Optional<Post> optional = postRepository.findAllById(postId);

    return optional.get();
  }

  public void incrementUpvotes(Post post) {
    postRepository.save(post);
  }

  public void savePost(Post post, Long UserId) {
    post.setPostuser(userService.findAllById(UserId));
    postRepository.save(post);
  }
}
