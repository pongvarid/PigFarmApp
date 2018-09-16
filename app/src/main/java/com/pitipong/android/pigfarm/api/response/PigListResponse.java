package com.pitipong.android.pigfarm.api.response;

import java.util.List;

public class PigListResponse {

    private int current_page;
    private String first_page_url;
    private int from;
    private int last_page;
    private String last_page_url;
    private String next_page_url;
    private String path;
    private int per_page;
    private Object prev_page_url;
    private int to;
    private int total;
    private List<DataBean> data;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public void setLast_page_url(String last_page_url) {
        this.last_page_url = last_page_url;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public Object getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(Object prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 855
         * pig_id : 591117
         * pig_number : null
         * birth_date : null
         * entry_date : null
         * source : null
         * male_breeder_pig_id : null
         * female_breeder_pig_id : null
         * left_breast : null
         * right_breast : null
         * blood_line : null
         * status : {"id":32,"parent_name":"PIGSTATUS","name":"PIGSTATUS_001","display_name":"อยู่ในฝูง","description":null,"children_fields":{},"values":{},"created_at":"2018-08-06 02:44:20","updated_at":"2018-08-06 02:44:20"}
         * created_at : 2018-08-31 13:24:13
         * updated_at : 2018-08-31 13:24:13
         * deleted_at : null
         * cycles : [{"id":876,"cycle_sequence":4,"pig_id":855,"complete":null,"remark":null,"created_at":"2018-08-31 13:24:13","updated_at":"2018-08-31 13:24:13","deleted_at":null,"breeders":[{"id":876,"pig_cycle_id":876,"pig_id":null,"breeder_a":"CP3","breeder_b":"CP18","breeder_c":null,"breed_date":"2018-05-31 00:00:00","delivery_date":"2018-09-24 13:24:13","breed_week":22,"gravid":0,"gravid_date":null,"gravid_out":null,"gravid_out_remark":null,"gravid_remark":null,"created_at":"2018-08-31 13:24:13","updated_at":"2018-08-31 13:24:13"}],"birth":[],"milk":[],"vaccine":[],"feed":[],"feed_out":[]}]
         */

        private int id;
        private String pig_id;
        private Object pig_number;
        private Object birth_date;
        private Object entry_date;
        private Object source;
        private Object male_breeder_pig_id;
        private Object female_breeder_pig_id;
        private Object left_breast;
        private Object right_breast;
        private Object blood_line;
        private StatusBean status;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private List<CyclesBean> cycles;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPig_id() {
            return pig_id;
        }

        public void setPig_id(String pig_id) {
            this.pig_id = pig_id;
        }

        public Object getPig_number() {
            return pig_number;
        }

        public void setPig_number(Object pig_number) {
            this.pig_number = pig_number;
        }

        public Object getBirth_date() {
            return birth_date;
        }

        public void setBirth_date(Object birth_date) {
            this.birth_date = birth_date;
        }

        public Object getEntry_date() {
            return entry_date;
        }

        public void setEntry_date(Object entry_date) {
            this.entry_date = entry_date;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getMale_breeder_pig_id() {
            return male_breeder_pig_id;
        }

        public void setMale_breeder_pig_id(Object male_breeder_pig_id) {
            this.male_breeder_pig_id = male_breeder_pig_id;
        }

        public Object getFemale_breeder_pig_id() {
            return female_breeder_pig_id;
        }

        public void setFemale_breeder_pig_id(Object female_breeder_pig_id) {
            this.female_breeder_pig_id = female_breeder_pig_id;
        }

        public Object getLeft_breast() {
            return left_breast;
        }

        public void setLeft_breast(Object left_breast) {
            this.left_breast = left_breast;
        }

        public Object getRight_breast() {
            return right_breast;
        }

        public void setRight_breast(Object right_breast) {
            this.right_breast = right_breast;
        }

        public Object getBlood_line() {
            return blood_line;
        }

        public void setBlood_line(Object blood_line) {
            this.blood_line = blood_line;
        }

        public StatusBean getStatus() {
            return status;
        }

        public void setStatus(StatusBean status) {
            this.status = status;
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

        public List<CyclesBean> getCycles() {
            return cycles;
        }

        public void setCycles(List<CyclesBean> cycles) {
            this.cycles = cycles;
        }

        public static class StatusBean {
            /**
             * id : 32
             * parent_name : PIGSTATUS
             * name : PIGSTATUS_001
             * display_name : อยู่ในฝูง
             * description : null
             * children_fields : {}
             * values : {}
             * created_at : 2018-08-06 02:44:20
             * updated_at : 2018-08-06 02:44:20
             */

            private int id;
            private String parent_name;
            private String name;
            private String display_name;
            private Object description;
            private ChildrenFieldsBean children_fields;
            private ValuesBean values;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getParent_name() {
                return parent_name;
            }

            public void setParent_name(String parent_name) {
                this.parent_name = parent_name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public ChildrenFieldsBean getChildren_fields() {
                return children_fields;
            }

            public void setChildren_fields(ChildrenFieldsBean children_fields) {
                this.children_fields = children_fields;
            }

            public ValuesBean getValues() {
                return values;
            }

            public void setValues(ValuesBean values) {
                this.values = values;
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

            public static class ChildrenFieldsBean {
            }

            public static class ValuesBean {
            }
        }

        public static class CyclesBean {
            /**
             * id : 876
             * cycle_sequence : 4
             * pig_id : 855
             * complete : null
             * remark : null
             * created_at : 2018-08-31 13:24:13
             * updated_at : 2018-08-31 13:24:13
             * deleted_at : null
             * breeders : [{"id":876,"pig_cycle_id":876,"pig_id":null,"breeder_a":"CP3","breeder_b":"CP18","breeder_c":null,"breed_date":"2018-05-31 00:00:00","delivery_date":"2018-09-24 13:24:13","breed_week":22,"gravid":0,"gravid_date":null,"gravid_out":null,"gravid_out_remark":null,"gravid_remark":null,"created_at":"2018-08-31 13:24:13","updated_at":"2018-08-31 13:24:13"}]
             * birth : []
             * milk : []
             * vaccine : []
             * feed : []
             * feed_out : []
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
            private List<?> milk;
            private List<?> vaccine;
            private List<?> feed;
            private List<?> feed_out;

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

            public List<?> getMilk() {
                return milk;
            }

            public void setMilk(List<?> milk) {
                this.milk = milk;
            }

            public List<?> getVaccine() {
                return vaccine;
            }

            public void setVaccine(List<?> vaccine) {
                this.vaccine = vaccine;
            }

            public List<?> getFeed() {
                return feed;
            }

            public void setFeed(List<?> feed) {
                this.feed = feed;
            }

            public List<?> getFeed_out() {
                return feed_out;
            }

            public void setFeed_out(List<?> feed_out) {
                this.feed_out = feed_out;
            }

            public static class BreedersBean {
                /**
                 * id : 876
                 * pig_cycle_id : 876
                 * pig_id : null
                 * breeder_a : CP3
                 * breeder_b : CP18
                 * breeder_c : null
                 * breed_date : 2018-05-31 00:00:00
                 * delivery_date : 2018-09-24 13:24:13
                 * breed_week : 22
                 * gravid : 0
                 * gravid_date : null
                 * gravid_out : null
                 * gravid_out_remark : null
                 * gravid_remark : null
                 * created_at : 2018-08-31 13:24:13
                 * updated_at : 2018-08-31 13:24:13
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
    }
}
