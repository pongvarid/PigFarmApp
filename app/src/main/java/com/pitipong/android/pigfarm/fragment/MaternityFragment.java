package com.pitipong.android.pigfarm.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pitipong.android.pigfarm.R;

public class MaternityFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_maternity, container, false);
    }
}
