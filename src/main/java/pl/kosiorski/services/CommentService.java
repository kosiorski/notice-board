package pl.kosiorski.services;

import pl.kosiorski.model.Comment;

import java.util.List;

public interface CommentService {

  Comment findById(Long id);

  List<Comment> findAll();

//  List<Comment> findByUserId(Long id);
//
//  List<Comment> findByAdId(Long id);

  Comment save(Comment comment);
}
