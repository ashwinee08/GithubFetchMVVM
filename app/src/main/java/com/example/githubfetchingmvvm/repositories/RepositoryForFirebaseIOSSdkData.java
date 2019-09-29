package com.example.githubfetchingmvvm.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.example.githubfetchingmvvm.models.Issue;
import com.example.githubfetchingmvvm.services.NetworkCallsUsingRetrofit;

import java.util.List;

public class RepositoryForFirebaseIOSSdkData{


    private static RepositoryForFirebaseIOSSdkData repositoryForFirebaseIOSSdkData;
    private final String baseUrl="https://api.github.com/repos/firebase/firebase-ios-sdk/ ";
    private MutableLiveData<Boolean> resultReceived=new MutableLiveData<>();

    private RepositoryForFirebaseIOSSdkData() {
    }

    public static RepositoryForFirebaseIOSSdkData getInstance(){
        if(repositoryForFirebaseIOSSdkData==null){
            repositoryForFirebaseIOSSdkData=new RepositoryForFirebaseIOSSdkData();
        }
        return repositoryForFirebaseIOSSdkData;
    }

    public MutableLiveData<List<Issue>> getIssues(){
        resultReceived.setValue(false);
        final MutableLiveData<List<Issue>> data=new MutableLiveData<>();
        if(data.getValue()==null){
            data.setValue(getDataFromRestServices());
        }

        return data;
    }

    private List<Issue> getDataFromRestServices(){
        return new NetworkCallsUsingRetrofit().getIssuesUsingRetroFit(baseUrl);
    }
}
