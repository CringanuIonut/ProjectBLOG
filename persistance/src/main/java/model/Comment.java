package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="comment")
public class Comment {
    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "articleId")
    private Long articleId;
    @Column(name = "date")
    private Date date;
    @Column(name = "lastedit")
    private Date lastedit;

    public Comment(){

    }

    public Date getLastedit() {
        return lastedit;
    }

    public void setLastedit(Date lastedit) {
        this.lastedit = lastedit;
    }

    public Comment(String content, Long articleId, Date date,Date lastedit) {
        this.content = content;
        this.articleId = articleId;
        this.date = date;
        this.lastedit=lastedit;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
