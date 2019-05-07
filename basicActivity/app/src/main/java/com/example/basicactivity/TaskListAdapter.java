package com.example.basicactivity;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//a class to display the data
public class TaskListAdapter
        extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskItemView;

        private TaskViewHolder(View itemView) {
            super(itemView);
            taskItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Task> mTasks; //cached cpy of tasks

    TaskListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position){
        if (mTasks != null) {
            Task current = mTasks.get(position);
            holder.taskItemView.setText(current.getTask());
        } else {
            //covers the case of data not being ready yet
            holder.taskItemView.setText("No Task");
        }
    }

    void setTasks(List<Task> tasks){
        mTasks = tasks;
        notifyDataSetChanged();
    }

    //getItemCount() is called many times
    //when first called, mTasks has not been updated
    //(initially null, and we can't return null)
    //this function accounts for the possibility that
    //the data is not yet ready and mTasks is still null
    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }
}
