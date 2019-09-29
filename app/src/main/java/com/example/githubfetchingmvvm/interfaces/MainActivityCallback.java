package com.example.githubfetchingmvvm.interfaces;

import com.example.githubfetchingmvvm.models.Issue;

import java.util.List;

public interface MainActivityCallback {
    void onRecyclerViewItemClicked(String commentsLink);
}
