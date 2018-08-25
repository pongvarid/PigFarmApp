package com.pitipong.android.pigfarm.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.activity.MainActivity;

import org.w3c.dom.Text;

public class WeanFragment extends Fragment {

    private TextView textViewDOW;
    private ImageView imageViewCalendar;

    public WeanFragment() {
        // Required empty public constructor
    }

    public static WeanFragment newInstance() {
        WeanFragment fragment = new WeanFragment();
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
        View view = inflater.inflate(R.layout.fragment_wean, container, false);
        initView(view);

        return view;
    }

    private void initView(View view){

        textViewDOW = view.findViewById(R.id.textViewDOW);

        imageViewCalendar = view.findViewById(R.id.imageViewCalendar);

        initClickEvent();
    }

    private void initClickEvent(){
        imageViewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).getDate(textViewDOW);
            }
        });
    }
}
