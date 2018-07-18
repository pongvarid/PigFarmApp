package com.pitipong.android.pigfarm.api.request;

import com.google.gson.annotations.SerializedName;
import com.pitipong.android.pigfarm.api.response.BaseResponse;
import com.pitipong.android.pigfarm.model.BloodLineModel;
import com.pitipong.android.pigfarm.model.CycleModel;

import org.parceler.Parcel;

import java.util.List;


public class PigDataRequest{

    @SerializedName("pig_id")
    private String pigID;
    @SerializedName("birth_date")
    private String birthDate;
    @SerializedName("entry_date")
    private String entryDate;
    @SerializedName("male_breeder_pig_id")
    private String maleBreederPigID;
    @SerializedName("female_breeder_pig_id")
    private String femaleBreederPigID;
    @SerializedName("left_breast")
    private int leftBreast;
    @SerializedName("right_breast")
    private int rightBreast;

    public PigDataRequest(String pigID, String birthDate, String entryDate, String maleBreederPigID, String femaleBreederPigID, int leftBreast, int rightBreast) {
        this.pigID = pigID;
        this.birthDate = birthDate;
        this.entryDate = entryDate;
        this.maleBreederPigID = maleBreederPigID;
        this.femaleBreederPigID = femaleBreederPigID;
        this.leftBreast = leftBreast;
        this.rightBreast = rightBreast;
    }
}
