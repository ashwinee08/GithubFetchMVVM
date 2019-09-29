package com.example.githubfetchingmvvm.interfaces;

import com.example.githubfetchingmvvm.models.Issue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("issues")
    Call<List<Issue>> getIssuesFromGithub();
}
