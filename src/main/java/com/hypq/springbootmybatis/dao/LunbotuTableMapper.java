package com.hypq.springbootmybatis.dao;

import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.domain.LunbotuTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LunbotuTableMapper {
    int countByExample(LunbotuTableExample example);

    int deleteByExample(LunbotuTableExample example);

    int insert(LunbotuTable record);

    int insertSelective(LunbotuTable record);

    List<LunbotuTable> selectByExample(LunbotuTableExample example);

    int updateByExampleSelective(@Param("record") LunbotuTable record, @Param("example") LunbotuTableExample example);

    int updateByExample(@Param("record") LunbotuTable record, @Param("example") LunbotuTableExample example);
}