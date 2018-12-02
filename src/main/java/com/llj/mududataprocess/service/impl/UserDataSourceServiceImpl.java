package com.llj.mududataprocess.service.impl;

import com.llj.mududataprocess.dao.FetchDataDao;
import com.llj.mududataprocess.modal.UserDataSourceRecord;
import com.llj.mududataprocess.modal.dto.UserDataRequestDto;
import com.llj.mududataprocess.service.UserDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataSourceServiceImpl implements UserDataSourceService {

    @Autowired
    private FetchDataDao fetchDataDao;
    @Override
    public int saveUserDataSource(UserDataSourceRecord userDataSourceRecord) {
        fetchDataDao.save(userDataSourceRecord);
        return 0;
    }

    @Override
    public int updateUserDataSource(UserDataSourceRecord userDataSourceRecord) {
        fetchDataDao.save(userDataSourceRecord);
        return 0;
    }

    @Override
    public Page selectUserDataSource(int page, int pageSize) {
        Page<UserDataSourceRecord>  pageSiz = fetchDataDao.findAll(PageRequest.of(page,pageSize));
        return pageSiz;
    }
}
