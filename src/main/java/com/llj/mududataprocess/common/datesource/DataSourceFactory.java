package com.llj.mududataprocess.common.datesource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;



public class DataSourceFactory {

    public static DataSource  DataSourceCreate(Properties properties){

        DataSource dataSource =  new DruidDataSource();
        try {
            dataSource=  DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
