package dao;

import model.Article;

import java.util.List;

public interface IArticleDao {
     List<Article> getAll();
    Article getArticle(Long articleId);
    void updateArticle(Article article);
    void addArticle(Article article);
    void deleteAllArticles(Long articleId);
}
