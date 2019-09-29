package com.example.githubfetchingmvvm.models;


public class Comment {
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public StringBuffer getComments() {
        return comments;
    }

    public void setComments(StringBuffer comments) {
        this.comments = comments;
    }

    private String authorName;
    private StringBuffer comments;
}
