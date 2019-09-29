package com.example.githubfetchingmvvm.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Issue {

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCommentsLink() {
        return commentsLink;
    }

    public void setCommentsLink(String commentsLink) {
        this.commentsLink = commentsLink;
    }


    @SerializedName("title")
    @Expose
    String issueTitle;

    @SerializedName("body")
    @Expose
    String Description;

    @SerializedName("comments_url")
    @Expose
    String commentsLink;
}
