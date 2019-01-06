package pl.kosiorski.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Comment;
import pl.kosiorski.repository.CommentRepository;
import pl.kosiorski.services.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;

  @Autowired
  public CommentServiceImpl(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @Override
  public Comment findById(Long id) {

    return commentRepository.findById(id).get();
  }

  @Override
  public List<Comment> findAll() {
    return commentRepository.findAll();
  }

//  @Override
//  public List<Comment> findByUserId(Long id) {
//    return commentRepository.findByUserId(id);
//  }
//
//  @Override
//  public List<Comment> findByAdId(Long id) {
//    return commentRepository.findByAdId(id);
//  }

  @Override
  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }
}
