package com.pitipong.android.pigfarm.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.activity.BreedAddActivity;
import com.pitipong.android.pigfarm.activity.MaternityAddActivity;

public class MaternityFragment extends Fragment {

    public FloatingActionButton fab;

    public MaternityFragment() {
        // Required empty public constructor
    }


    public static MaternityFragment newInstance() {
        MaternityFragment fragment = new MaternityFragment();

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
        View view = inflater.inflate(R.layout.fragment_maternity, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MaternityAddActivity.class));
            }
        });
    }
}
