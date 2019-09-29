package com.example.githubfetchingmvvm.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubfetchingmvvm.models.Issue;
import com.example.githubfetchingmvvm.repositories.RepositoryForFirebaseIOSSdkData;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<List<Issue>> listOfIssues;

    private void initData(){
        listOfIssues=RepositoryForFirebaseIOSSdkData.getInstance().getIssues();
    }

    public LiveData<List<Issue>> getLiveData(){
        if(listOfIssues==null){
            initData();
        }
        return listOfIssues;
    }
}
