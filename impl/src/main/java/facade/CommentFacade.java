package facade;


import dao.ICommentDao;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CommentFacade implements ICommentFacade {
    @Autowired
    private ICommentDao commentDao;

    public ICommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(ICommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> getAllComments(Long articleId) {
        return this.commentDao.getAllComments(articleId);
    }

    public Comment getComment(Long articleId, Long commentid) {
        return this.commentDao.getComment(articleId,commentid);
    }

    public void updateComment(Comment comment) {
        this.commentDao.updateComment(comment);
    }

    public void addComment(Comment comment) {
        this.commentDao.addComment(comment);
    }

    public void deleteAllComments(Long articleId, Long commentid) {
        this.commentDao.deleteAllComments(articleId,commentid);

    }


}
