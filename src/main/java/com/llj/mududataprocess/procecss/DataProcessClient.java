package com.llj.mududataprocess.procecss;


import java.util.ArrayList;
import java.util.List;

public class DataProcessClient {
    private List<DataProcessor> list;

    public DataProcessClient(List<DataProcessor> list) {
        this.list = list;
    }

    public DataProcessClient(){
        list = new ArrayList<>();
    }

    public void addProcessor(DataProcessor processor){
        list.add(processor);
    }

    public DataProcessResult excute(DataProcessRequest request){
        List<DataProcessor> processors = new ArrayList<>(list);
        DataProcessChain dataProcessClient = new DataProcessChain(0,processors,request);
        DataProcessResult result = dataProcessClient.proceed(request);
        return result;
    }
}
