package dao;

import model.Comment;

import java.util.List;


public interface ICommentDao {
    List<Comment> getAllComments(Long articleId);
    Comment getComment(Long articleId, Long commentid);
    void updateComment(Comment comment);
    void addComment(Comment comment);
    void deleteAllComments(Long articleId, Long commentid);

}
