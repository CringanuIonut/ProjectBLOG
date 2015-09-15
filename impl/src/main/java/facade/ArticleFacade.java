package facade;


import dao.IArticleDao;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleFacade implements IArticleFacade{
    @Autowired
    private IArticleDao articleDao;



    public List<Article> bringArticle(){
        return this.articleDao.getAll();
    }

    public IArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public Article getArticle(Long articleId){
       return this.articleDao.getArticle(articleId);
    }

    public void updateArticle(Article article){
        this.articleDao.updateArticle(article);
    }
     public void addArticle(Article article){
         this.articleDao.addArticle(article);

     }
    public void deleteAllArticles(Long articleId){
         this.articleDao.deleteAllArticles(articleId);
    }

}
