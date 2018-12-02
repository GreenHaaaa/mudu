package com.llj.mududataprocess.modal.dto;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserDataRequestDto {


    private String driverClassName;

    private String url;

    private String user;

    private String password;

    private String sql;
}
