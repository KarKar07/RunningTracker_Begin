package com.example.runner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RunAdapter extends RecyclerView.Adapter<RunAdapter.RunViewHolder> {

    private final List<run> runs;

    public RunAdapter(List<run> runs) {
        this.runs = runs;
    }

    @NonNull
    @Override
    public RunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_run, parent, false);
        return new RunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RunViewHolder holder, int position) {
        run run = runs.get(position);
        holder.tvDate.setText(run.date);
        holder.tvDistance.setText(String.format("%.2f км", run.distanceKm));
        holder.tvDuration.setText(run.duration);
    }

    @Override
    public int getItemCount() {
        return runs.size();
    }

    static class RunViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvDistance, tvDuration;

        RunViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            tvDuration = itemView.findViewById(R.id.tvDuration);
        }
    }
}