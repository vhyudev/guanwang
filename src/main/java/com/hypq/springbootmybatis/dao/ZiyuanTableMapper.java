package com.hypq.springbootmybatis.dao;

import com.hypq.springbootmybatis.domain.SuccessTable;
import com.hypq.springbootmybatis.domain.ZiyuanTable;
import com.hypq.springbootmybatis.domain.ZiyuanTableExample;
import com.hypq.springbootmybatis.domain.ZiyuanTableWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZiyuanTableMapper {
    int countByExample(ZiyuanTableExample example);

    int deleteByExample(ZiyuanTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZiyuanTableWithBLOBs record);

    int insertSelective(ZiyuanTableWithBLOBs record);

    List<ZiyuanTableWithBLOBs> selectByExampleWithBLOBs(ZiyuanTableExample example);

    List<ZiyuanTable> selectByExample(ZiyuanTableExample example);

    ZiyuanTableWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZiyuanTableWithBLOBs record, @Param("example") ZiyuanTableExample example);

    int updateByExampleWithBLOBs(@Param("record") ZiyuanTableWithBLOBs record, @Param("example") ZiyuanTableExample example);

    int updateByExample(@Param("record") ZiyuanTable record, @Param("example") ZiyuanTableExample example);

    int updateByPrimaryKeySelective(ZiyuanTableWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ZiyuanTableWithBLOBs record);

    int updateByPrimaryKey(ZiyuanTable record);
    ZiyuanTableWithBLOBs getUp(Integer id);

    ZiyuanTableWithBLOBs getDown(Integer id);
}