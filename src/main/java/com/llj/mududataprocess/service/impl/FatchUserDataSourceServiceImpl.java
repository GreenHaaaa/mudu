package com.llj.mududataprocess.service.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.llj.mududataprocess.common.datesource.DataSourceFactory;
import com.llj.mududataprocess.modal.dto.UserDataRequestDto;
import com.llj.mududataprocess.procecss.DataProcessClient;
import com.llj.mududataprocess.procecss.DataProcessRequest;
import com.llj.mududataprocess.procecss.DataProcessResult;
import com.llj.mududataprocess.procecss.processor.StandardAddZeroProcessor;
import com.llj.mududataprocess.service.FatchUserDataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class FatchUserDataSourceServiceImpl implements FatchUserDataSourceService {

    @Override
    public List FetchData(UserDataRequestDto userDataRequestDto) {
        Properties properties = new Properties();
        BeanUtils.copyProperties(userDataRequestDto,properties);
        DataSource datasource =DataSourceFactory.DataSourceCreate(properties);
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            result = JdbcUtils.executeQuery(datasource,userDataRequestDto.getSql(),1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void  main(String[] args){


        Properties properties = new Properties();
        properties.setProperty("url","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT");
        properties.setProperty("username","root");
        properties.setProperty("password","111111");
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        DataSource datasource = DataSourceFactory.DataSourceCreate(properties);
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            result = JdbcUtils.executeQuery(datasource,"select * from test where 1 = ?",1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result.size());
        DataProcessClient dataProcessClient = new DataProcessClient();
        dataProcessClient.addProcessor(new StandardAddZeroProcessor());
        Map<String,String> map = new HashMap<>();
        map.put("StandardProcessor","test");
        DataProcessResult ProcessResult = dataProcessClient.excute(new DataProcessRequest.Builder().data(result).prop(map).build());
        log.info(""+ProcessResult.getList().size());
    }
}
