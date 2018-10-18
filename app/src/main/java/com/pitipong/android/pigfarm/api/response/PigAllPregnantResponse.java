package com.pitipong.android.pigfarm.api.response;

import java.util.List;

public class PigAllPregnantResponse {


    /**
     * id : 1
     * cycle_sequence : 4
     * pig_id : 1
     * complete : null
     * remark : null
     * created_at : 2018-08-31 13:23:45
     * updated_at : 2018-08-31 13:23:45
     * deleted_at : null
     * breeders : [{"id":1,"pig_cycle_id":1,"pig_id":null,"breeder_a":"CP30","breeder_b":"CP18","breeder_c":null,"breed_date":"2018-04-01 00:00:00","delivery_date":"2018-07-26 13:23:45","breed_week":13,"gravid":0,"gravid_date":null,"gravid_out":null,"gravid_out_remark":null,"gravid_remark":null,"created_at":"2018-08-31 13:23:45","updated_at":"2018-08-31 13:23:45"}]
     * birth : []
     * feed : []
     * feedout : []
     * milk : []
     */

    private int id;
    private int cycle_sequence;
    private int pig_id;
    private Object complete;
    private Object remark;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private List<BreedersBean> breeders;
    private List<?> birth;
    private List<?> feed;
    private List<?> feedout;
    private List<?> milk;

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

    public Object getComplete() {
        return complete;
    }

    public void setComplete(Object complete) {
        this.complete = complete;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
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

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public List<BreedersBean> getBreeders() {
        return breeders;
    }

    public void setBreeders(List<BreedersBean> breeders) {
        this.breeders = breeders;
    }

    public List<?> getBirth() {
        return birth;
    }

    public void setBirth(List<?> birth) {
        this.birth = birth;
    }

    public List<?> getFeed() {
        return feed;
    }

    public void setFeed(List<?> feed) {
        this.feed = feed;
    }

    public List<?> getFeedout() {
        return feedout;
    }

    public void setFeedout(List<?> feedout) {
        this.feedout = feedout;
    }

    public List<?> getMilk() {
        return milk;
    }

    public void setMilk(List<?> milk) {
        this.milk = milk;
    }

    public static class BreedersBean {
        /**
         * id : 1
         * pig_cycle_id : 1
         * pig_id : null
         * breeder_a : CP30
         * breeder_b : CP18
         * breeder_c : null
         * breed_date : 2018-04-01 00:00:00
         * delivery_date : 2018-07-26 13:23:45
         * breed_week : 13
         * gravid : 0
         * gravid_date : null
         * gravid_out : null
         * gravid_out_remark : null
         * gravid_remark : null
         * created_at : 2018-08-31 13:23:45
         * updated_at : 2018-08-31 13:23:45
         */

        private int id;
        private int pig_cycle_id;
        private Object pig_id;
        private String breeder_a;
        private String breeder_b;
        private Object breeder_c;
        private String breed_date;
        private String delivery_date;
        private int breed_week;
        private int gravid;
        private Object gravid_date;
        private Object gravid_out;
        private Object gravid_out_remark;
        private Object gravid_remark;
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

        public Object getPig_id() {
            return pig_id;
        }

        public void setPig_id(Object pig_id) {
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

        public Object getBreeder_c() {
            return breeder_c;
        }

        public void setBreeder_c(Object breeder_c) {
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

        public Object getGravid_date() {
            return gravid_date;
        }

        public void setGravid_date(Object gravid_date) {
            this.gravid_date = gravid_date;
        }

        public Object getGravid_out() {
            return gravid_out;
        }

        public void setGravid_out(Object gravid_out) {
            this.gravid_out = gravid_out;
        }

        public Object getGravid_out_remark() {
            return gravid_out_remark;
        }

        public void setGravid_out_remark(Object gravid_out_remark) {
            this.gravid_out_remark = gravid_out_remark;
        }

        public Object getGravid_remark() {
            return gravid_remark;
        }

        public void setGravid_remark(Object gravid_remark) {
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
