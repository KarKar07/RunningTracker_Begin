package com.example.runner;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StatsFragment extends Fragment {

    private static final String TAG = "Lifecycle";
    private static final String ARG_PERIOD = "period";

    public static StatsFragment newInstance(String period) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PERIOD, period);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        String period = getArguments() != null ? getArguments().getString(ARG_PERIOD) : "week";
        TextView tvStats = view.findViewById(R.id.tvStats);
        tvStats.setText("Статистика за период: " + period);

        return view;
    }

    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }
}