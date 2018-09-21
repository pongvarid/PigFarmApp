package com.pitipong.android.pigfarm.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class BreedersModel {

    @SerializedName("id")
    private int id;
    @SerializedName("pig_cycle_id")
    private int pigCycleId;
    @SerializedName("pig_id")
    private String pigId;
    @SerializedName("breeder_a")
    private String breederA;
    @SerializedName("breeder_b")
    private String breederB;
    @SerializedName("breeder_c")
    private String breederC;
    @SerializedName("breed_date")
    private String breedDate;
    @SerializedName("delivery_date")
    private String deliveryDate;
    @SerializedName("breed_week")
    private int breedWeek;
    @SerializedName("gravid")
    private int gravid;
    @SerializedName("gravid_date")
    private String gravidDate;
    @SerializedName("gravid_out")
    private String gravidOut;
    @SerializedName("gravid_out_remark")
    private String gravidOutRemark;
    @SerializedName("gravid_remark")
    private String gravidRemark;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPigCycleId() {
        return pigCycleId;
    }

    public void setPigCycleId(int pigCycleId) {
        this.pigCycleId = pigCycleId;
    }

    public String getPigId() {
        return pigId;
    }

    public void setPigId(String pigId) {
        this.pigId = pigId;
    }

    public String getBreederA() {
        return breederA;
    }

    public void setBreederA(String breederA) {
        this.breederA = breederA;
    }

    public String getBreederB() {
        return breederB;
    }

    public void setBreederB(String breederB) {
        this.breederB = breederB;
    }

    public String getBreederC() {
        return breederC;
    }

    public void setBreederC(String breederC) {
        this.breederC = breederC;
    }

    public String getBreedDate() {
        return breedDate;
    }

    public void setBreedDate(String breedDate) {
        this.breedDate = breedDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getBreedWeek() {
        return breedWeek;
    }

    public void setBreedWeek(int breedWeek) {
        this.breedWeek = breedWeek;
    }

    public int getGravid() {
        return gravid;
    }

    public void setGravid(int gravid) {
        this.gravid = gravid;
    }

    public String getGravidDate() {
        return gravidDate;
    }

    public void setGravidDate(String gravidDate) {
        this.gravidDate = gravidDate;
    }

    public String getGravidOut() {
        return gravidOut;
    }

    public void setGravidOut(String gravidOut) {
        this.gravidOut = gravidOut;
    }

    public String getGravidOutRemark() {
        return gravidOutRemark;
    }

    public void setGravidOutRemark(String gravidOutRemark) {
        this.gravidOutRemark = gravidOutRemark;
    }

    public String getGravidRemark() {
        return gravidRemark;
    }

    public void setGravidRemark(String gravidRemark) {
        this.gravidRemark = gravidRemark;
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
}
