package com.example.githubfetchingmvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubfetchingmvvm.R;
import com.example.githubfetchingmvvm.interfaces.MainActivityCallback;
import com.example.githubfetchingmvvm.models.Issue;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<Issue> listOfIssues;
    private MainActivityCallback callbackReference;
    private Issue issue;

    public RecyclerViewAdapter(Context context, List<Issue> listOfIssues) {
         this.context=context;
         this.listOfIssues = listOfIssues;
        callbackReference =(MainActivityCallback)context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        issue=listOfIssues.get(position);
        holder.setIssueTitleTextView(issue.getIssueTitle());
        holder.setDescriptionTextView(issue.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackReference.onRecyclerViewItemClicked(issue.getCommentsLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfIssues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView issueTitleTextView;
        private TextView DescriptionTextView;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            issueTitleTextView=itemView.findViewById(R.id.issue_title);
            DescriptionTextView =itemView.findViewById(R.id.description);
            this.itemView=itemView;

        }

        public void setIssueTitleTextView(String issueTitle){
            issueTitleTextView.setText(issueTitle);
        }

        public void setDescriptionTextView(String description){
            DescriptionTextView.setText(description);
        }

    }
}
