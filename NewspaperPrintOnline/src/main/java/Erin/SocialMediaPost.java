package Erin;

import java.io.Serializable;
import java.time.LocalDate;


public class SocialMediaPost implements Serializable {
    private static final long serialVersionUID = 1L;

    private String postId;
    private String content;
    private String platform;
    private LocalDate postDate;
    private int likes;
    private int shares;
    private int comments;

    public SocialMediaPost(String content, String platform) {
        this.postId = String.valueOf(System.currentTimeMillis());
        this.content = content;
        this.platform = platform;
        this.postDate = LocalDate.now();

        this.likes = 0;
        this.shares = 0;
        this.comments = 0;
    }


    public int getTotalEngagement() {

        return likes + shares + comments;
    }


    public String getContent() { return content; }
    public String getPlatform() { return platform; }
    public LocalDate getPostDate() { return postDate; }
    public int getLikes() { return likes; }
    public int getShares() { return shares; }
    public int getComments() { return comments; }
    public String getPostId() { return postId; }

    public void setLikes(int likes) { this.likes = likes; }
    public void setShares(int shares) { this.shares = shares; }
    public void setComments(int comments) { this.comments = comments; }
}