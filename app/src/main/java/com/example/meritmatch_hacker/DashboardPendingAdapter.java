package com.example.meritmatch_hacker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashboardPendingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER = 0;
    private static final int ITEM = 1;

    private ArrayList<ClassTaskDetails> tasks;
    private Context context;

    public DashboardPendingAdapter(ArrayList<ClassTaskDetails> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? HEADER : ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == HEADER) {
            View view = inflater.inflate(R.layout.recyclverview_title, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.dashboard_row, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.header.setText("Pending Tasks");
        } else {
            ItemViewHolder itemHolder = (ItemViewHolder) holder;
            ClassTaskDetails task = tasks.get(position - 1);
            itemHolder.t1.setText(task.getTitle());
            itemHolder.t2.setText(String.valueOf(task.getReward()));
            itemHolder.t3.setText(task.getDescription());
            itemHolder.t4.setText(task.getDeadline());
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size() + 1;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3,t4;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.dbtv1);
            t2 = itemView.findViewById(R.id.dbtv2);
            t3 = itemView.findViewById(R.id.dbtv3);
            t4 = itemView.findViewById(R.id.dbtv4);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.dbheader);
        }
    }
}
