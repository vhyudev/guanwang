package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.ZiyuanTableWithBLOBs;

import java.util.List;
import java.util.Map;

public interface ZiyuanService {
    int getCount();
    List<ZiyuanTableWithBLOBs> getAll();

    void addZiyuan(ZiyuanTableWithBLOBs st);

    List<ZiyuanTableWithBLOBs> getZiyuanItems();

    void deleteZiyuanCase(String id);

    ZiyuanTableWithBLOBs getZiyuanById(Integer id);

    Map<String,ZiyuanTableWithBLOBs> getUpandDown(Integer id);
}
