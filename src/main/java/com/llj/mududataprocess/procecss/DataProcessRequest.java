package com.llj.mududataprocess.procecss;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DataProcessRequest {
    private List<Map<String,Object>> data;
    private Map<String,String> prop;

    public DataProcessRequest(Builder builder){
        this.data = builder.data;
        this.prop = builder.prop;
    }

     public static class Builder{
        private List<Map<String,Object>> data;
        private Map<String,String> prop;

        public Builder data(List list){
            data = list;
            return this;
        }
        public Builder prop(Map<String,String> prop){
            this.prop = prop;
            return this;
        }
        public DataProcessRequest build(){
            return new DataProcessRequest(this);
        }


    }
}
