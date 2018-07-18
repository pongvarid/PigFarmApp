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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.activity.MainActivity;
import com.pitipong.android.pigfarm.activity.SearchPigIDActivity;
import com.pitipong.android.pigfarm.api.Api;
import com.pitipong.android.pigfarm.api.request.PigDataRequest;
import com.pitipong.android.pigfarm.api.response.PigDataResponse;
import com.pitipong.android.pigfarm.helper.MessageBox;
import com.pitipong.android.pigfarm.listener.IButtonEventListener;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static com.pitipong.android.pigfarm.api.ServiceURL.APPLICATION_JSON;

    public class HistoryFragment extends Fragment {

    private TextView textViewDisplayDOB, textViewDisplayImportToFarm;
    private ImageView imageViewCalendar, imageViewCalendarImportToFarm;
    private EditText
            edittextLeftBreast,
            edittextRightBreast,
            edittextMaleBreederPigID,
            edittextFemaleBreederPigID;
    private LinearLayout linearLayoutSaveHistoryl;

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

        edittextLeftBreast = v.findViewById(R.id.edittextLeftBreast);
        edittextRightBreast = v.findViewById(R.id.edittextRightBreast);
        edittextMaleBreederPigID = v.findViewById(R.id.edittextMaleBreederPigID);
        edittextFemaleBreederPigID = v.findViewById(R.id.edittextFemaleBreederPigID);

        textViewDisplayDOB = v.findViewById(R.id.textViewDisplayDOB);
        textViewDisplayImportToFarm = v.findViewById(R.id.textViewDisplayImportToFarm);

        linearLayoutSaveHistoryl = v.findViewById(R.id.linearLayoutSaveHistory);

        bindDataToView();
        initClickEvent();
    }

    private void bindDataToView(){
        textViewDisplayDOB.setText(((MainActivity)getActivity()).pigData.getBirthDate());
        textViewDisplayImportToFarm.setText(((MainActivity)getActivity()).pigData.getEntryDate());

        edittextLeftBreast.setText(""+((MainActivity)getActivity()).pigData.getLeftBreast());
        edittextRightBreast.setText(""+((MainActivity)getActivity()).pigData.getRightBreast());

        edittextMaleBreederPigID.setText(((MainActivity)getActivity()).pigData.getMaleBreederPigID());
        edittextFemaleBreederPigID.setText(((MainActivity)getActivity()).pigData.getFemaleBreederPigID());
    }

    private void initClickEvent(){
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
        linearLayoutSaveHistoryl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).showLoadingProgress();
                postPigDataService();
            }
        });
    }

    private void postPigDataService(){
        Call<PigDataResponse> pigDataResponseCall = Api.getInstance(getActivity()).getService().postPigData(
                "Bearer " + Application.pm.getAccessToken(),
                APPLICATION_JSON,APPLICATION_JSON,
                ((MainActivity)getActivity()).pigData.getId(),
                new PigDataRequest(
                        ((MainActivity)getActivity()).pigData.getPigID(),
                        textViewDisplayDOB.getText().toString(),
                        textViewDisplayImportToFarm.getText().toString(),
                        edittextMaleBreederPigID.getText().toString(),
                        edittextFemaleBreederPigID.getText().toString(),
                        Integer.parseInt(edittextLeftBreast.getText().toString()),
                        Integer.parseInt(edittextRightBreast.getText().toString())));
        pigDataResponseCall.enqueue(new Callback<PigDataResponse>() {
            @Override
            public void onResponse(Response<PigDataResponse> response, Retrofit retrofit) {
                if (response.code() == 200){
                    if (response.body() != null){
                        Toast.makeText(getActivity(), "บันทึกการแก้ไขเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                    } else {
                        MessageBox.getInstance().alertMessage(response.body().getMessage(), getActivity(), new IButtonEventListener() {
                            @Override
                            public void onClickPositive() {

                            }

                            @Override
                            public void onClickNegative() {

                            }
                        });
                    }
                }
                ((MainActivity)getActivity()).dismissLoadingProgress();
            }

            @Override
            public void onFailure(Throwable t) {
                MessageBox.getInstance().alertMessage("พบข้อผิดพลาด กรุณาลองอีกครั้ง", getActivity(), new IButtonEventListener() {
                    @Override
                    public void onClickPositive() {

                    }

                    @Override
                    public void onClickNegative() {

                    }
                });
                ((MainActivity)getActivity()).dismissLoadingProgress();
            }
        });
    }
}
