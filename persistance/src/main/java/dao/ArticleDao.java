package dao;


import model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class ArticleDao implements IArticleDao {
    private EntityManager entityManager;

    @PersistenceContext
    private void setEntityManager(EntityManager entityManager){

        this.entityManager =entityManager;
    }

    public List<Article> getAll(){
        return this.entityManager.createQuery("from Article").getResultList();
    }
    @Transactional
    public Article getArticle(Long articleId) {
            return this.entityManager.find(Article.class, articleId);
    }
    @Transactional
    public void updateArticle(Article article){
        Article articleFromDb=this.getArticle(article.getId());
            if (articleFromDb!=null){
                articleFromDb.setComments(article.getComments());
                articleFromDb.setDescription(article.getDescription());
                articleFromDb.setTitle(article.getTitle());
                this.entityManager.persist(articleFromDb);
            }



    }
    @Transactional
    public void  addArticle(Article article) {
        this.entityManager.persist(article);

    }
    @Transactional
    public void deleteAllArticles(Long articleId) {
        Article articleFromDb = this.getArticle(articleId);
        if (articleFromDb != null) {
            this.entityManager.remove(articleFromDb);
        }
    }
}
