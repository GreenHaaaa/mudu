package com.llj.mududataprocess.procecss;

import java.util.List;

public class DataProcessChain implements DataProcessor.Chain {
    private int index;
    private List<DataProcessor> processors;
    private DataProcessRequest dataProcessRequest;

    public DataProcessChain(int index, List<DataProcessor> processors, DataProcessRequest dataProcessRequest) {
        this.index = index;
        this.processors = processors;
        this.dataProcessRequest = dataProcessRequest;
    }

    @Override
    public DataProcessRequest request() {
        return dataProcessRequest;
    }

    @Override
    public DataProcessResult proceed(DataProcessRequest request) {
        DataProcessResult proceed = new DataProcessResult();
        proceed.setList(request.getData());
        if (processors.size() > index) {
            DataProcessChain realChain = new DataProcessChain(index+1,processors, request);
            DataProcessor processor = processors.get(index);
            proceed = processor.process(realChain);
        }
        return proceed;
    }
}
