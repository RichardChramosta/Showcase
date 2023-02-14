package com.example.doplereddit;

import com.example.doplereddit.models.Comment;
import com.example.doplereddit.models.Post;
import com.example.doplereddit.models.User;
import com.example.doplereddit.repositories.CommentRepository;
import com.example.doplereddit.repositories.PostRepository;
import com.example.doplereddit.repositories.UserRepository;
import com.example.doplereddit.services.PostServiceImpl;
import com.example.doplereddit.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DopleRedditApplication implements CommandLineRunner {
  PostRepository postRepository;
  UserRepository userRepository;
  CommentRepository commentRepository;
  PostServiceImpl postService;
  UserServiceImpl userService;

  public DopleRedditApplication(PostRepository postRepository,UserRepository userRepository,PostServiceImpl postService,CommentRepository commentRepository, UserServiceImpl userService) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
    this.postService =postService;
    this.commentRepository=commentRepository;
    this.userService =userService;
  }
  public static void main(String[] args) {
    SpringApplication.run(DopleRedditApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {



            String workshop = "this is workshop posts, nothing to be learn here";
        User user = new User("Richard","tralala");
        userRepository.save(user);
        Post post1 = new Post("It works as we intended it to in Internet Explorer.", workshop);
       Post post2 = new Post("Polish history in on picture", workshop);
       Post post3 = new Post("Motion sensors were not installed the right way.",workshop);
       Post post4 = new Post("This sing at my gym", workshop);

        long helpid = user.getId();

        post1.setPostuser(userService.findAllById(helpid));
        post2.setPostuser(userService.findAllById(helpid));
        post3.setPostuser(userService.findAllById(helpid));
        post4.setPostuser(userService.findAllById(helpid));
      post1.setUpvotes(554);
      post2.setUpvotes(44);
        post3.setUpvotes(8);
        post4.setUpvotes(2);
      postRepository.save(post1);
       postRepository.save(post2);
       postRepository.save(post3);
        postRepository.save(post4);
//
//        Comment comment = new Comment("ohh I like that");
//        comment.setCommentUser(userService.findAllById(37L));
//        comment.setThisPost(postService.findPostById(41L));
//        commentRepository.save(comment);
  }
}
