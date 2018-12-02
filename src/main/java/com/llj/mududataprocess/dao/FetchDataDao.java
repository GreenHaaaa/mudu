package com.llj.mududataprocess.dao;

import com.llj.mududataprocess.modal.UserDataSourceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FetchDataDao extends JpaRepository<UserDataSourceRecord,Long> {




}
