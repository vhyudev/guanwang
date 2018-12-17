package com.hypq.springbootmybatis.dao;

import com.hypq.springbootmybatis.domain.LiuyanTable;
import com.hypq.springbootmybatis.domain.LiuyanTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiuyanTableMapper {
    int countByExample(LiuyanTableExample example);

    int deleteByExample(LiuyanTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LiuyanTable record);

    int insertSelective(LiuyanTable record);

    List<LiuyanTable> selectByExample(LiuyanTableExample example);

    LiuyanTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LiuyanTable record, @Param("example") LiuyanTableExample example);

    int updateByExample(@Param("record") LiuyanTable record, @Param("example") LiuyanTableExample example);

    int updateByPrimaryKeySelective(LiuyanTable record);

    int updateByPrimaryKey(LiuyanTable record);
}