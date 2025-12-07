package Samiha.Journalist;

import java.io.Serializable;
import java.time.LocalDate;

public class Article implements Serializable {
    private String articleId,articleTitle,description, articleStatus;
    private LocalDate submissionDate;

    public String getArticleId() {
        return articleId;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getDescription() {
        return description;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Article(String articleId, String articleTitle, String description) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.description = description;

        this.articleStatus = "Pending";
        this.submissionDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", description='" + description + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
