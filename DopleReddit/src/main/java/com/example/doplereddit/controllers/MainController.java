package com.example.doplereddit.controllers;

import com.example.doplereddit.models.Comment;
import com.example.doplereddit.models.Post;
import com.example.doplereddit.models.User;
import com.example.doplereddit.repositories.CommentRepository;
import com.example.doplereddit.repositories.PostRepository;
import com.example.doplereddit.repositories.UserRepository;
import com.example.doplereddit.services.CommentService;
import com.example.doplereddit.services.CommentServiceImpl;
import com.example.doplereddit.services.PostService;
import com.example.doplereddit.services.PostServiceImpl;
import com.example.doplereddit.services.UserService;
import com.example.doplereddit.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  UserRepository userRepository;
  PostRepository postRepository;
  CommentRepository commentRepository;
  CommentService commentService;

  PostService postService;
  UserService userService;

  public MainController(UserRepository userRepository, CommentRepository commentRepository,
      CommentService commentService,
      PostService postService, PostRepository postRepository, UserService userService) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.commentRepository = commentRepository;
    this.postService = postService;
    this.userService = userService;
    this.commentService = commentService;
  }

  @GetMapping("/")
  public String MainPage() {
    return "login";
  }

  @PostMapping("/login")
  public String LoginTransition(@RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "password", required = false) String password, Model model) {
    User user = postService.findUser(name, password);
    Long UserId = user.getId();
    return "redirect:/loginpage/" + UserId;
  }

  @PostMapping("/register")
  public String RegisterTransition(@RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "password", required = false) String password,
      Model model) {
    User user = new User(name, password);
//        userRepository.save(user);
    postService.saveUser(user);
    Long UserId = user.getId();
//        model.addAttribute("UserId",UserId);
    return "redirect:/loginpage/" + UserId;
  }

  @GetMapping(value = "/loginpage/{UserId}")
  public String LogAndSurf(Model model, @PathVariable(name = "UserId") Long UserId) {

    model.addAttribute("user", postService.readUser(UserId));

    model.addAttribute("posts", postRepository.findAll());
    return "loginPage";
  }

  @PostMapping(value = "/loginpage/{UserId}/upvote")
  public String incementUpvotes(Long postId, @PathVariable(name = "UserId") Long UserId) {
    Post post = postService.findPostById(postId);
    post.setUpvotes(post.getUpvotes() + 1);
    postService.incrementUpvotes(post);
    return "redirect:/loginpage/" + UserId;
  }

  @PostMapping(value = "/loginpage/{UserId}/downvotes")
  public String decrementUpvotes(Long postId, @PathVariable(name = "UserId") Long UserId) {
    Post post = postService.findPostById(postId);
    post.setUpvotes(post.getUpvotes() - 1);
    postService.incrementUpvotes(post);
    return "redirect:/loginpage/" + UserId;
  }

  @GetMapping(value = "/submit/{UserId}")
  public String submiNewPost(Model model, @PathVariable(name = "UserId") Long UserId) {
    model.addAttribute("userid", UserId);
    return "submitPost";

  }

  @PostMapping(value = "/postsubmit/{UserId}")
  public String subNewPost(Model model, @PathVariable(name = "UserId") Long UserId,
      @RequestParam(name = "description", required = false) String description,
      @RequestParam(name = "content", required = false) String content
  ) {
    Post post = new Post(description, content);
    postService.savePost(post, UserId);
    return "redirect:/loginpage/" + UserId;
  }


  @RequestMapping(value = "/loginpage/{UserId}/postpage")
  public String postPage(Long postId, Model model, @PathVariable(name = "UserId") Long UserId) {
    Post post = postService.findPostById(postId);
    model.addAttribute("post", post);
    model.addAttribute("userid", UserId);
    model.addAttribute("postId", postId);
    model.addAttribute("user", post.getPostuser());
    //  List<Comment> comments = commentService.findAllcomments(postId);

    return "postPage";
  }


  @PostMapping(value = "/loginpage/{UserId}/postcomment/{postId}")
  public String subNewComment(@PathVariable Long postId, Model model,
      @PathVariable(name = "UserId") Long UserId,
      @RequestParam(name = "text", required = false) String text

  ) {
    Comment comment = new Comment(text);
    commentService.saveComments(comment, UserId, postId);
    return "redirect:/loginpage/" + UserId + "/postpage?postId=" + postId;
  }

}
