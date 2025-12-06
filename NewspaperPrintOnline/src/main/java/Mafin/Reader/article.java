package Mafin.Reader;

import java.io.Serializable;

public class article implements Serializable {
    private String articleId;
    private String title, articleType ;
    private String description;
    private String status;
    private String comment;
    private String publicationdate;

    public String getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(String publicationdate) {
        this.publicationdate = publicationdate;
    }

    public article(String publicationdate) {
        this.publicationdate = publicationdate;
    }

    public article(String articleId, String title, String articleType, String description) {
        this.articleId = articleId;
        this.title = title;
        this.articleType = articleType;
        this.description = description;

        this.status = "Pending";
        this.comment = null;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
