package com.example.githubfetchingmvvm.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.githubfetchingmvvm.R;
import com.example.githubfetchingmvvm.adapters.RecyclerViewAdapter;
import com.example.githubfetchingmvvm.interfaces.MainActivityCallback;
import com.example.githubfetchingmvvm.models.Issue;
import com.example.githubfetchingmvvm.view_models.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityCallback {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MainActivityViewModel mainActivityViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getHold();

        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);

        this.initRecyclerView(mainActivityViewModel.getLiveData().getValue());

        this.handleViewModel();


    }

    private void handleViewModel(){
        mainActivityViewModel.getLiveData().observe(this, new Observer<List<Issue>>() {
            @Override
            public void onChanged(List<Issue> issues) {
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }


    private void getHold(){
        recyclerView=findViewById(R.id.recycler_view);
    }


    private void initRecyclerView(List<Issue> listOfIssues){
        recyclerView.setLayoutManager(this.getInstanceOfLinearLayoutManager());
        recyclerViewAdapter=new RecyclerViewAdapter(this,listOfIssues);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private LinearLayoutManager getInstanceOfLinearLayoutManager(){
        if(linearLayoutManager==null){
            linearLayoutManager=new LinearLayoutManager(this);
        }
        return linearLayoutManager;
    }

    @Override
    public void onRecyclerViewItemClicked(String commentsLink){
        Bundle bundle=new Bundle();
        bundle.putString("commentsLink",commentsLink);
        startActivity(
                (new Intent(this, DetailsActivity.class)
                        .putExtras(bundle)
                )
        );
    }

}
