package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Column(name = "Id")
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Comments")
    private String comments;
    @Column(name = "Date")
    private Date date;
    @Column(name = "lastedit")
    private Date lastedit;

    public Article() {
    }

    public Date getLastedit() {
        return lastedit;
    }

    public void setLastedit(Date lastedit) {
        this.lastedit = lastedit;
    }

    public Article(String title, String description, String comments,Date date,Date lastedit) {
        this.title = title;
        this.description = description;
        this.comments = comments;
        this.date=date;
        this.lastedit=lastedit;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
