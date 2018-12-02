package com.llj.mududataprocess.modal;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserDataSourceRecord {
    @Id
    private Long Uid;

    private String DBname;

    private String dataSourceName;

    private String driverClassName;

    private String url;

    private String user;

    private String  port;

    private String password;

    private String dbNOfUser;
}
