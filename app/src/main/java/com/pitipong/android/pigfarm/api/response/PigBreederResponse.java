package com.pitipong.android.pigfarm.api.response;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class PigBreederResponse {

    /**
     * id : 888
     * cycle_sequence : 1
     * pig_id : 867
     * complete : 2
     * remark :
     * created_at : 2018-09-18 10:17:22
     * updated_at : 2018-09-18 10:17:34
     * deleted_at : null
     * breeders : [{"id":888,"pig_cycle_id":888,"pig_id":"867","breeder_a":"2","breeder_b":"3","breeder_c":"3","breed_date":"20-09-2561","delivery_date":"14-01-2562","breed_week":16,"gravid":0,"gravid_date":null,"gravid_out":null,"gravid_out_remark":null,"gravid_remark":null,"created_at":"2018-09-18 10:17:33","updated_at":"2018-09-18 10:17:33"}]
     * birth : []
     * feed : []
     * feedout : []
     * milk : []
     */

    private int id;
    private int cycle_sequence;
    private int pig_id;
    private int complete;
    private String remark;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private List<BreedersBean> breeders;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCycle_sequence() {
        return cycle_sequence;
    }

    public void setCycle_sequence(int cycle_sequence) {
        this.cycle_sequence = cycle_sequence;
    }

    public int getPig_id() {
        return pig_id;
    }

    public void setPig_id(int pig_id) {
        this.pig_id = pig_id;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public List<BreedersBean> getBreeders() {
        return breeders;
    }

    public void setBreeders(List<BreedersBean> breeders) {
        this.breeders = breeders;
    }

    @Parcel
    public static class BreedersBean {
        /**
         * id : 888
         * pig_cycle_id : 888
         * pig_id : 867
         * breeder_a : 2
         * breeder_b : 3
         * breeder_c : 3
         * breed_date : 20-09-2561
         * delivery_date : 14-01-2562
         * breed_week : 16
         * gravid : 0
         * gravid_date : null
         * gravid_out : null
         * gravid_out_remark : null
         * gravid_remark : null
         * created_at : 2018-09-18 10:17:33
         * updated_at : 2018-09-18 10:17:33
         */

        private int id;
        private int pig_cycle_id;
        private String pig_id;
        private String breeder_a;
        private String breeder_b;
        private String breeder_c;
        private String breed_date;
        private String delivery_date;
        private int breed_week;
        private int gravid;
        private String gravid_date;
        private String gravid_out;
        private String gravid_out_remark;
        private String gravid_remark;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPig_cycle_id() {
            return pig_cycle_id;
        }

        public void setPig_cycle_id(int pig_cycle_id) {
            this.pig_cycle_id = pig_cycle_id;
        }

        public String getPig_id() {
            return pig_id;
        }

        public void setPig_id(String pig_id) {
            this.pig_id = pig_id;
        }

        public String getBreeder_a() {
            return breeder_a;
        }

        public void setBreeder_a(String breeder_a) {
            this.breeder_a = breeder_a;
        }

        public String getBreeder_b() {
            return breeder_b;
        }

        public void setBreeder_b(String breeder_b) {
            this.breeder_b = breeder_b;
        }

        public String getBreeder_c() {
            return breeder_c;
        }

        public void setBreeder_c(String breeder_c) {
            this.breeder_c = breeder_c;
        }

        public String getBreed_date() {
            return breed_date;
        }

        public void setBreed_date(String breed_date) {
            this.breed_date = breed_date;
        }

        public String getDelivery_date() {
            return delivery_date;
        }

        public void setDelivery_date(String delivery_date) {
            this.delivery_date = delivery_date;
        }

        public int getBreed_week() {
            return breed_week;
        }

        public void setBreed_week(int breed_week) {
            this.breed_week = breed_week;
        }

        public int getGravid() {
            return gravid;
        }

        public void setGravid(int gravid) {
            this.gravid = gravid;
        }

        public String getGravid_date() {
            return gravid_date;
        }

        public void setGravid_date(String gravid_date) {
            this.gravid_date = gravid_date;
        }

        public String getGravid_out() {
            return gravid_out;
        }

        public void setGravid_out(String gravid_out) {
            this.gravid_out = gravid_out;
        }

        public String getGravid_out_remark() {
            return gravid_out_remark;
        }

        public void setGravid_out_remark(String gravid_out_remark) {
            this.gravid_out_remark = gravid_out_remark;
        }

        public String getGravid_remark() {
            return gravid_remark;
        }

        public void setGravid_remark(String gravid_remark) {
            this.gravid_remark = gravid_remark;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
