package com.service;
import facade.IArticleFacade;
import model.Article;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleService {
    @Autowired
    private IArticleFacade articleFacade;

    @DateTimeFormat
    @RequestMapping(value = "", method = RequestMethod.GET)
     @ResponseBody
     public List<Article> getAllArticles(){
        return this.articleFacade.bringArticle();

    }
    @DateTimeFormat
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article getArticle(@PathVariable("id") Long articleId){

        return this.articleFacade.getArticle(articleId);

    }

    public IArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(IArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAllArticles(@PathVariable("id")Long Id){

        this.articleFacade.deleteAllArticles(Id);


    }

    @DateTimeFormat
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public void addArticle(@RequestBody Article newEntry){


        this.articleFacade.addArticle(newEntry);
    }

    @DateTimeFormat
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateArticle(@PathVariable("id") Long articleId, @RequestBody Article articleUpdates) {
        articleUpdates.setId(articleId);


        this.articleFacade.updateArticle(articleUpdates);
    }
}
