package com.hypq.springbootmybatis.dao;

import com.hypq.springbootmybatis.domain.SuccessTable;
import com.hypq.springbootmybatis.domain.SuccessTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuccessTableMapper {
    int countByExample(SuccessTableExample example);

    int deleteByExample(SuccessTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SuccessTable record);

    int insertSelective(SuccessTable record);

    List<SuccessTable> selectByExample(SuccessTableExample example);

    SuccessTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SuccessTable record, @Param("example") SuccessTableExample example);

    int updateByExample(@Param("record") SuccessTable record, @Param("example") SuccessTableExample example);

    int updateByPrimaryKeySelective(SuccessTable record);

    int updateByPrimaryKey(SuccessTable record);
}