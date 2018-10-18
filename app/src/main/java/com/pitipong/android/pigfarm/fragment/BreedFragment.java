package com.pitipong.android.pigfarm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.activity.BreedCreateAndEditActivity;
import com.pitipong.android.pigfarm.activity.MainActivity;
import com.pitipong.android.pigfarm.adapter.BreederAdapter;
import com.pitipong.android.pigfarm.api.Api;
import com.pitipong.android.pigfarm.api.response.PigBreederResponse;
import com.pitipong.android.pigfarm.listener.IBreederClickEvent;

import org.parceler.Parcels;

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

    private List<PigBreederResponse> pigBreederResponses;
    private BreederAdapter breederAdapter;

    private TextView textViewDataNotFound;
    private ListView listViewBreeder;

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

    private void initView(View view) {
        fab = view.findViewById(R.id.fab);
        textViewDataNotFound = view.findViewById(R.id.textViewDataNotFound);
        listViewBreeder = view.findViewById(R.id.listViewBreeder);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BreedCreateAndEditActivity.class));
            }
        });
    }

    private void getPigBreederList() {
        Call<List<PigBreederResponse>> pigList = Api.getInstance(getActivity()).getService().getPigBreeder(
                BEARER + Application.pm.getAccessToken(),
                APPLICATION_JSON, APPLICATION_JSON,
                ((MainActivity) getActivity()).pigData.getId());
        pigList.enqueue(new Callback<List<PigBreederResponse>>() {
            @Override
            public void onResponse(Response<List<PigBreederResponse>> response, Retrofit retrofit) {
                Log.e(TAG, "onResponse: test");
                pigBreederResponses = response.body();
                if (response.body().size() != 0){
                    hasData(true);
                    breederAdapter = new BreederAdapter(getActivity(), pigBreederResponses, new IBreederClickEvent() {
                        @Override
                        public void onClickItem(int position) {
                            Intent intent = new Intent(getActivity(), BreedCreateAndEditActivity.class);
                            intent.putExtra("PigBreeder", Parcels.wrap(pigBreederResponses));
                            intent.putExtra("position", position);
                            startActivity(intent);
                        }
                    });
                    listViewBreeder.setAdapter(breederAdapter);
                } else {
                    hasData(false);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: ");
            }
        });
    }

    private void hasData(boolean hasData) {
        if (hasData) {
            textViewDataNotFound.setVisibility(View.GONE);
            listViewBreeder.setVisibility(View.VISIBLE);
        } else {
            textViewDataNotFound.setVisibility(View.VISIBLE);
            listViewBreeder.setVisibility(View.GONE);
        }
    }
}
