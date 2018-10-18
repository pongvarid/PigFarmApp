package com.pitipong.android.pigfarm.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.api.response.PigBreederResponse;
import com.pitipong.android.pigfarm.listener.IBreederClickEvent;

import java.util.List;

public class BreederAdapter extends BaseAdapter {

    private Context context;
    private List<PigBreederResponse> pigBreederResponse;
    private IBreederClickEvent iBreederClickEvent;

    public BreederAdapter(Context context, List<PigBreederResponse> pigBreederResponse,IBreederClickEvent iBreederClickEvent) {
        this.context = context;
        this.pigBreederResponse = pigBreederResponse;
        this.iBreederClickEvent = iBreederClickEvent;
    }

    @Override
    public int getCount() {
        if (pigBreederResponse.size() == 0) {
            return 0;
        }
        return pigBreederResponse.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_breed, parent, false);
            mHolder = new ViewHolder(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }

        mHolder.textViewCounterRound.setText("รอบที่ : "+(i+1));

        if (i % 2 == 0){
            mHolder.linearLayoutBreederRoot.setBackgroundColor(ContextCompat.getColor(context, R.color.color_breeder_bg_1));
        } else {
            mHolder.linearLayoutBreederRoot.setBackgroundColor(ContextCompat.getColor(context, R.color.color_breeder_bg_2));
        }

        for (int j = 0; j < pigBreederResponse.get(i).getBreeders().size(); j++) {
            mHolder.editTextBreedWeek.setText("" + pigBreederResponse.get(i).getBreeders().get(j).getBreed_week());
            mHolder.editTextBreederA.setText("" + pigBreederResponse.get(i).getBreeders().get(j).getBreeder_a());
            mHolder.editTextBreederB.setText("" + pigBreederResponse.get(i).getBreeders().get(j).getBreeder_b());
            mHolder.editTextBreederC.setText("" + pigBreederResponse.get(i).getBreeders().get(j).getBreeder_c());
            mHolder.textViewBreedDate.setText(pigBreederResponse.get(i).getBreeders().get(j).getBreed_date());
            mHolder.textViewDeliveryDate.setText(pigBreederResponse.get(i).getBreeders().get(j).getDelivery_date());

        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iBreederClickEvent.onClickItem(i);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        LinearLayout linearLayoutBreederRoot;
        TextView textViewBreedDate,
                textViewCounterRound,
                textViewDeliveryDate;
        EditText editTextBreedWeek,
                editTextBreederA,
                editTextBreederB,
                editTextBreederC;

        ViewHolder(View view) {

            linearLayoutBreederRoot = view.findViewById(R.id.linearLayoutBreederRoot);

            editTextBreedWeek = view.findViewById(R.id.breed_week);
            editTextBreederA = view.findViewById(R.id.breeder_a);
            editTextBreederB = view.findViewById(R.id.breeder_b);
            editTextBreederC = view.findViewById(R.id.breeder_c);

            textViewCounterRound = view.findViewById(R.id.textViewCounterRound);
            textViewBreedDate = view.findViewById(R.id.breed_date);
            textViewDeliveryDate = view.findViewById(R.id.delivery_date);

        }
    }
}
