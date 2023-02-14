package com.example.doplereddit.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String Text;

  private Date postedAt = new Date();

  private Date updatedAt = new Date();
  @ManyToOne
  @JoinColumn(name = "userId")
  private User commentUser;
  @ManyToOne
  @JoinColumn(name = "postId")
  private Post thisPost;

  public Comment() {
  }

  public Comment(String text) {
    Text = text;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return Text;
  }

  public void setText(String text) {
    Text = text;
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

  public User getCommentUser() {
    return commentUser;
  }

  public void setCommentUser(User commentUser) {
    this.commentUser = commentUser;
  }

  public Post getThisPost() {
    return thisPost;
  }

  public void setThisPost(Post thisPost) {
    this.thisPost = thisPost;
  }
}
