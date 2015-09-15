package facade;


import model.Article;

import java.util.List;

public interface IArticleFacade  {

     List<Article> bringArticle();
    Article getArticle(Long articleId);
    void updateArticle(Article article);
    void addArticle(Article article);
    void deleteAllArticles(Long articleId);

}
