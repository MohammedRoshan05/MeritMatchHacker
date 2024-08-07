package com.example.meritmatch_hacker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityDashboard extends AppCompatActivity {

    Button posttask,gototasks;
    RecyclerView pending,posted;
    DashboardPostedAdapter postedAdapter;
    DashboardPendingAdapter pendingAdapter;
    ArrayList<ClassTaskDetails> postedtasks,pendingtasks;
    String User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        User = getUsername();
        System.out.println(User);

        postedtasks = new ArrayList<>();
        posted = findViewById(R.id.posted_tasks);
        postedAdapter = new DashboardPostedAdapter(postedtasks,this);
        posted.setAdapter(postedAdapter);
        posted.setLayoutManager(new LinearLayoutManager(this));

        new APICall().getPostedTasks(User, ActivityDashboard.this, new APICall.getTasksCallback() {
            @Override
            public void onResponse(List<ClassTaskDetails> tasks) {
                if(tasks != null){
                    postedtasks.addAll(tasks);
                    postedAdapter.notifyDataSetChanged();
                }
            }
        });

        pendingtasks = new ArrayList<>();
        pending = findViewById(R.id.pending_tasks);
        pendingAdapter = new DashboardPendingAdapter(pendingtasks,this);
        pending.setAdapter(pendingAdapter);
        pending.setLayoutManager(new LinearLayoutManager(this));

        new APICall().getPendingTasks(User, ActivityDashboard.this, new APICall.getTasksCallback() {
            @Override
            public void onResponse(List<ClassTaskDetails> tasks) {
                if(tasks != null){
                    pendingtasks.addAll(tasks);
                    pendingAdapter.notifyDataSetChanged();
                }
            }
        });

        posttask = findViewById(R.id.post_task);
        posttask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDashboard.this,ActivityPostTask.class);
                intent.putExtra("Username",User);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public String getUsername(){
        Intent intent = getIntent();
        return intent.getStringExtra("Username");
    }
}