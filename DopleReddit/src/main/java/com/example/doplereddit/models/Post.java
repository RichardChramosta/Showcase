package com.example.doplereddit.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String description;

  private Integer upvotes;

  private String content;

  private Date postedAt = new Date();

  private Date updatedAt = new Date();

  @OneToMany(mappedBy = "thisPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Comment> mycomments;
  @ManyToOne
  @JoinColumn(name = "userId")
  private User postUser;

  public Post() {
  }

  public Post(String description, String content) {
    this.description = description;
    this.content = content;
    this.upvotes = 0;
  }

  public List<Comment> getMycomments() {
    return mycomments;
  }

  public void setMycomments(List<Comment> mycomments) {
    this.mycomments = mycomments;
  }

  public User getPostuser() {
    return postUser;
  }

  public void setPostuser(User postuser) {
    this.postUser = postuser;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getUpvotes() {
    return upvotes;
  }

  public void setUpvotes(Integer upvotes) {
    this.upvotes = upvotes;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getPostedAt() {
    return postedAt;
  }

  public void setPostedAt(Date postedAt) {
    this.postedAt = postedAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
