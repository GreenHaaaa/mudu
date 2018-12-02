package com.llj.mududataprocess.service;

import com.llj.mududataprocess.modal.UserDataSourceRecord;
import com.llj.mududataprocess.modal.dto.UserDataRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserDataSourceService  {
    /**
     * 保存
     * @param userDataSourceRecord
     * @return
     */
    int saveUserDataSource(UserDataSourceRecord userDataSourceRecord);

    int updateUserDataSource(UserDataSourceRecord userDataSourceRecord);

    Page selectUserDataSource(int page, int pageSize);
}
