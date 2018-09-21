package com.pitipong.android.pigfarm.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class CycleModel {

    @SerializedName("id")
    private int id;
    @SerializedName("cycle_sequence")
    private int cycleSequence;
    @SerializedName("pig_id")
    private int pigId;
    @SerializedName("complete")
    private String complete;
    @SerializedName("remark")
    private String remark;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("deletedAt")
    private String deletedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCycleSequence() {
        return cycleSequence;
    }

    public void setCycleSequence(int cycleSequence) {
        this.cycleSequence = cycleSequence;
    }

    public int getPigId() {
        return pigId;
    }

    public void setPigId(int pigId) {
        this.pigId = pigId;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
