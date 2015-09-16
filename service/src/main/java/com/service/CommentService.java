package com.service;



import facade.ICommentFacade;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller

public class CommentService {
    @Autowired
    private ICommentFacade commentFacade;



    @DateTimeFormat
    @RequestMapping(value = "/article/{articleId}/comment",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment>getAllComments(@PathVariable("articleId")Long articleId){
        return this.commentFacade.getAllComments(articleId);

    }
    @DateTimeFormat
    @RequestMapping(value = "/article/{articleId}/comment/{commentid}",method = RequestMethod.GET)
    @ResponseBody
    public Comment getComment(@PathVariable("articleId")Long articleId,@PathVariable("commentid")Long commentid){
        return this.commentFacade.getComment(articleId, commentid);
    }
    @DateTimeFormat
    @RequestMapping(value = "/article/{articleId}/comment",method = RequestMethod.POST)
    @ResponseBody
    public void addComment(@PathVariable("articleId")Long articleId,@RequestBody Comment comment){
        comment.setArticleId(articleId);
        comment.setDate(new Date());
         this.commentFacade.addComment(comment);
    }
    @DateTimeFormat
    @RequestMapping(value = "/article/{articleId}/comment/{commentid}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateComment(@PathVariable("articleId")Long articleId,@PathVariable("commentid")Long commentid,@RequestBody Comment comment){
        comment.setArticleId(articleId);
        comment.setId(commentid);

        this.commentFacade.updateComment(comment);
    }

    @RequestMapping(value = "/article/{articleId}/comment/{commentid}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAllComments (@PathVariable("articleId")Long articleId,@PathVariable("commentid")Long commentid){

        this.commentFacade.deleteAllComments(articleId, commentid);
    }



    public ICommentFacade getCommentFacade() {
        return commentFacade;
    }

    public void setCommentFacade(ICommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }

}
