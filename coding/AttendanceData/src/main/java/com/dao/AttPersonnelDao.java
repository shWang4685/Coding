package com.dao;


import com.entity.AttPersonnel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttPersonnelDao {
    List<AttPersonnel> getAllAttPersonnel();
    int insertAttPer(AttPersonnel attPersonnel);
}
