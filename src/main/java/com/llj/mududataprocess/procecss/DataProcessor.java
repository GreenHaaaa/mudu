package com.llj.mududataprocess.procecss;

public interface DataProcessor {

    /**
     * 对数据的处理方法，实现这个方法需要在实现结束后，需要使用DataProcessChain.proceed()继续责任链，实现对
     * 请求的转发
     * @param dataProcessChain
     * @return
     */
    DataProcessResult process(DataProcessChain dataProcessChain);

    interface Chain {
        // 获取当前request
        DataProcessRequest request();

        // 转发request
        DataProcessResult proceed(DataProcessRequest request);
    }

}

