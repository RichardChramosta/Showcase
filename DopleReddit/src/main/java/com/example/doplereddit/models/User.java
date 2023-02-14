package com.example.doplereddit.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private String password;
  @OneToMany(mappedBy= "commentUser",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Comment> userComments;
  @OneToMany(mappedBy = "postUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Post> posts;

  public User() {
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Comment> getUserComments() {
    return userComments;
  }

  public void setUserComments(List<Comment> userComments) {
    this.userComments = userComments;
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
