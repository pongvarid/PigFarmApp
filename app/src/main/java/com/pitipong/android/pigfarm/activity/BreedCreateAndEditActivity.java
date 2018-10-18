package com.pitipong.android.pigfarm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.api.response.PigBreederResponse;

import org.parceler.Parcels;

import java.util.List;

public class BreedCreateAndEditActivity extends BaseActivity {

    private static final String TAG = "BreedCreateAndEditActivity";

    private List<PigBreederResponse> pigBreederResponses;
    private int position;

    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_add);
        getPigDataFromParcel();
        initView();
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getPigDataFromParcel() {
        Bundle bundle = getIntent().getExtras();
        pigBreederResponses = Parcels.unwrap(bundle.getParcelable("PigBreeder"));
        position = bundle.getInt("position");

//        textViewPigID.setText("ID : "+pigData.getPigID());

        Log.e(TAG, "getPigDataFromParcel: " + pigBreederResponses + " Position = "+position);
    }

}
