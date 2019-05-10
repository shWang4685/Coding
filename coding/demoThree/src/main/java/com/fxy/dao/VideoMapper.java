package com.fxy.dao;

import com.fxy.bean.Video;
import com.fxy.bean.VideoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper 
public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}