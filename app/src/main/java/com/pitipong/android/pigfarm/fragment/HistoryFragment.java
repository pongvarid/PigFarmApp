    package com.pitipong.android.pigfarm.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.activity.MainActivity;

    public class HistoryFragment extends Fragment {

    private TextView textViewDisplayDOB, textViewDisplayImportToFarm;
    private ImageView imageViewCalendar, imageViewCalendarImportToFarm;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        initView(view);
        return view;
    }

    private void initView(View v){
        imageViewCalendar = v.findViewById(R.id.imageViewCalendar);
        imageViewCalendarImportToFarm = v.findViewById(R.id.imageViewCalendarImportToFarm);

        textViewDisplayDOB = v.findViewById(R.id.textViewDisplayDOB);
        textViewDisplayImportToFarm = v.findViewById(R.id.textViewDisplayImportToFarm);

        textViewDisplayDOB.setText(((MainActivity)getActivity()).pigDataResponse.getBirthDate());
        textViewDisplayImportToFarm.setText(((MainActivity)getActivity()).pigDataResponse.getEntryDate());

        imageViewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getDate(textViewDisplayDOB);
            }
        });
        imageViewCalendarImportToFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getDate(textViewDisplayImportToFarm);
            }
        });
    }
}
