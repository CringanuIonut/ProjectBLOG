package dao;



import model.Comment;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;


public class CommentDao implements ICommentDao {

    private EntityManager entityManager;
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Comment> getAllComments(Long articleId) {

        Query query = this.entityManager.createQuery("from Comment where articleId=:articleId");
        query.setParameter("articleId",articleId);
        return query.getResultList();
    }

    public Comment getComment(Long articleId, Long commentid) {
        Query query = this.entityManager.createQuery("from Comment where articleId=:articleId and id=:commentid");
        query.setParameter("articleId",articleId);
        query.setParameter("commentid",commentid);
        return (Comment) query.getSingleResult();
    }
    @Transactional
    public void updateComment(Comment comment) {
        Comment commentFromDb=this.getComment(comment.getArticleId(), comment.getId());
        if (commentFromDb!=null) {
            commentFromDb.setContent(comment.getContent());
            this.entityManager.persist(commentFromDb);

        }

    }
    @Transactional
    public void addComment(Comment comment) {
        this.entityManager.persist(comment);
    }
    @Transactional
    public void deleteAllComments(Long articleId, Long commentid) {
        Comment commentFromDb=this.getComment(articleId,commentid);
        if (commentFromDb!=null) {

            this.entityManager.remove(commentFromDb);
        }

    }

}
