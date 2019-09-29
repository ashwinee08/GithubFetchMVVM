package com.example.githubfetchingmvvm.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.githubfetchingmvvm.interfaces.RetrofitInterface;
import com.example.githubfetchingmvvm.models.Issue;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkCallsUsingRetrofit{

    List<Issue> listOfIssues=new ArrayList<>();

    public List<Issue> getIssuesUsingRetroFit(String baseUrl){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterface retrofitInterfaceReference=retrofit.create(RetrofitInterface.class);
        Call<List<Issue>> call=retrofitInterfaceReference.getIssuesFromGithub();
        call.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                if(response.isSuccessful()){
                    listOfIssues=response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {
                Log.e("ERROR--------------:", t.getMessage());
            }
        });
        return listOfIssues;
    }
}
