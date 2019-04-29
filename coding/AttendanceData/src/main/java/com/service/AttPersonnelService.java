package com.service;

import com.entity.AttPersonnel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttPersonnelService {
    List<AttPersonnel> getAllAttPersonnel();
    int insertAttPersonnel(String parm);
}
