package com.llj.mududataprocess.service;

import com.llj.mududataprocess.modal.dto.UserDataRequestDto;

import java.util.List;

public interface FatchUserDataSourceService {
    /**
     * 抓取用户信息
     * @param userDataRequestDto
     * @return
     */
    List FetchData(UserDataRequestDto userDataRequestDto);
}
