package com.pitipong.android.pigfarm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.activity.BreedAddActivity;
import com.pitipong.android.pigfarm.activity.MainActivity;
import com.pitipong.android.pigfarm.api.Api;
import com.pitipong.android.pigfarm.api.response.PigBreederResponse;
import com.pitipong.android.pigfarm.api.response.PigListResponse;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static com.pitipong.android.pigfarm.api.ServiceURL.APPLICATION_JSON;
import static com.pitipong.android.pigfarm.api.ServiceURL.BEARER;

public class BreedFragment extends Fragment {

    private static final String TAG = "BreedFragment";

    public FloatingActionButton fab;

    public BreedFragment() {
        // Required empty public constructor
    }

    public static BreedFragment newInstance() {
        BreedFragment fragment = new BreedFragment();
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
        View view = inflater.inflate(R.layout.fragment_breed, container, false);
        initView(view);
        getPigBreederList();
        return view;
    }

    private void initView(View view){
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BreedAddActivity.class));
            }
        });
    }

    private void getPigBreederList(){
        Call<PigBreederResponse> pigList = Api.getInstance(getActivity()).getService().getPigBreeder(
                BEARER + Application.pm.getAccessToken(),
                APPLICATION_JSON,APPLICATION_JSON,
                ((MainActivity)getActivity()).pigData.getPigID(),
                "","","","","",
                "","");
        pigList.enqueue(new Callback<PigBreederResponse>() {
            @Override
            public void onResponse(Response<PigBreederResponse> response, Retrofit retrofit) {
                Log.e(TAG, "onResponse: test" );
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: " );
            }
        });
    }
}
