package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kosiorski.model.Comment;
import pl.kosiorski.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping("/list")
  public List<Comment> commentList() {
    return commentService.findAll();
  }

  @RequestMapping("/add")
  public Comment commentAdd(Comment comment) {
    return commentService.save(comment);
  }
}
