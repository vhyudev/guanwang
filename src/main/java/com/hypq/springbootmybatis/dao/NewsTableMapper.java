package com.hypq.springbootmybatis.dao;

import com.hypq.springbootmybatis.domain.NewsTable;
import com.hypq.springbootmybatis.domain.NewsTable;
import com.hypq.springbootmybatis.domain.NewsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsTableMapper {
    int countByExample(NewsTableExample example);

    int deleteByExample(NewsTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(NewsTable record);

    int insertSelective(NewsTable record);

    List<NewsTable> selectByExample(NewsTableExample example);

    NewsTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NewsTable record, @Param("example") NewsTableExample example);

    int updateByExample(@Param("record") NewsTable record, @Param("example") NewsTableExample example);

    int updateByPrimaryKeySelective(NewsTable record);

    int updateByPrimaryKey(NewsTable record);
}