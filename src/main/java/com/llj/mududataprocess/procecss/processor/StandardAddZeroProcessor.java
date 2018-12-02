package com.llj.mududataprocess.procecss.processor;

import com.llj.mududataprocess.procecss.DataProcessChain;
import com.llj.mududataprocess.procecss.DataProcessRequest;
import com.llj.mududataprocess.procecss.DataProcessResult;
import com.llj.mududataprocess.procecss.DataProcessor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StandardAddZeroProcessor implements DataProcessor {
    @Override
    public DataProcessResult process(DataProcessChain dataProcessChain) {
        DataProcessRequest request = dataProcessChain.request();
        String columnName = request.getProp().get("StandardAddZeroProcessor");
        List<Map<String,Object>> list = request.getData();
        List<Map<String,Object>> newList  =  new ArrayList<>();
        int index =0;
        for (int i = 0; i < list.size() ; i++,index++) {
            Map<String,Object> resource = list.get(i);
            if(Integer.parseInt((String)resource.get(columnName))!=index){
                Map<String,Object> map = new LinkedHashMap<>();
                for (String key:resource.keySet()){
                    if(key .equals(columnName)){
                        map.put(key,String.valueOf(index));
                    }
                    map.put(key,String.valueOf(0));
                }
                newList.add(map);
                --i;

            }else {
                newList.add(resource);
            }

        }
        DataProcessRequest newRequest = new DataProcessRequest.Builder()
                                    .data(newList).build();
        return dataProcessChain.proceed(newRequest);
    }
}
