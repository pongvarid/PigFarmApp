package com.pitipong.android.pigfarm.api.response;

import android.os.AsyncTask;

import com.google.gson.annotations.SerializedName;
import com.pitipong.android.pigfarm.model.BreedersModel;
import com.pitipong.android.pigfarm.model.CycleModel;
import com.pitipong.android.pigfarm.model.StatusModel;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class PigDataResponse extends BaseResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("pig_id")
    private String pigID;
    @SerializedName("pig_number")
    private int pigNumber;
    @SerializedName("birth_date")
    private String birthDate;
    @SerializedName("entry_date")
    private String entryDate;
    @SerializedName("source")
    private String source;
    @SerializedName("male_breeder_pig_id")
    private String maleBreederPigID;
    @SerializedName("female_breeder_pig_id")
    private String femaleBreederPigID;
    @SerializedName("left_breast")
    private int leftBreast;
    @SerializedName("right_breast")
    private int rightBreast;
    @SerializedName("blood_line")
    private String bloodLine;
    @SerializedName("status")
    private String status;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("deleted_at")
    private String deletedAt;
    @SerializedName("cycles")
    private List<CycleModel> cycleModel;
//    @SerializedName("status")
//    private StatusModel statusModel;
    @SerializedName("breeders")
    private BreedersModel breedersModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPigID() {
        return pigID;
    }

    public void setPigID(String pigID) {
        this.pigID = pigID;
    }

    public int getPigNumber() {
        return pigNumber;
    }

    public void setPigNumber(int pigNumber) {
        this.pigNumber = pigNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMaleBreederPigID() {
        return maleBreederPigID;
    }

    public void setMaleBreederPigID(String maleBreederPigID) {
        this.maleBreederPigID = maleBreederPigID;
    }

    public String getFemaleBreederPigID() {
        return femaleBreederPigID;
    }

    public void setFemaleBreederPigID(String femaleBreederPigID) {
        this.femaleBreederPigID = femaleBreederPigID;
    }

    public int getLeftBreast() {
        return leftBreast;
    }

    public void setLeftBreast(int leftBreast) {
        this.leftBreast = leftBreast;
    }

    public int getRightBreast() {
        return rightBreast;
    }

    public void setRightBreast(int rightBreast) {
        this.rightBreast = rightBreast;
    }

//    public BloodLineModel getBloodLineModel() {
//        return bloodLine;
//    }
//
//    public void setBloodLineModel(BloodLineModel bloodLine) {
//        this.bloodLine = bloodLine;
//    }


    public String getBloodLine() {
        return bloodLine;
    }

    public void setBloodLine(String bloodLine) {
        this.bloodLine = bloodLine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<CycleModel> getCycleModel() {
        return cycleModel;
    }

    public void setCycleModel(List<CycleModel> cycleModel) {
        this.cycleModel = cycleModel;
    }

//    public StatusModel getStatusModel() {
//        return statusModel;
//    }
//
//    public void setStatusModel(StatusModel statusModel) {
//        this.statusModel = statusModel;
//    }

    public BreedersModel getBreedersModel() {
        return breedersModel;
    }

    public void setBreedersModel(BreedersModel breedersModel) {
        this.breedersModel = breedersModel;
    }
}
