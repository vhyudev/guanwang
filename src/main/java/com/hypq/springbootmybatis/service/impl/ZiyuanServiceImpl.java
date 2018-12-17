package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.ZiyuanTableMapper;
import com.hypq.springbootmybatis.domain.ZiyuanTableExample;
import com.hypq.springbootmybatis.domain.ZiyuanTableWithBLOBs;

import com.hypq.springbootmybatis.service.ZiyuanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ZiyuanServiceImpl implements ZiyuanService {
    @Resource
    ZiyuanTableMapper mapper;

    @Override
    public List<ZiyuanTableWithBLOBs> getAll() {
        ZiyuanTableExample e = new ZiyuanTableExample();
        List<ZiyuanTableWithBLOBs> ZiyuanTableWithBLOBss = mapper.selectByExampleWithBLOBs(e);
        return ZiyuanTableWithBLOBss;
    }

    @Override
    public void addZiyuan(ZiyuanTableWithBLOBs st) {
        Integer id = st.getId();

        if(id==null){
            mapper.insert(st);
        }else {
            ZiyuanTableExample e = new ZiyuanTableExample();
            e.createCriteria().andIdEqualTo(st.getId());
            mapper.updateByExampleSelective(st,e);
        }

    }

    @Override
    public List<ZiyuanTableWithBLOBs> getZiyuanItems() {
        return mapper.selectByExampleWithBLOBs(new ZiyuanTableExample());
    }

    @Override
    public void deleteZiyuanCase(String id) {
        mapper.deleteByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public ZiyuanTableWithBLOBs getZiyuanById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,ZiyuanTableWithBLOBs> getUpandDown(Integer id) {
        Map<String,ZiyuanTableWithBLOBs> map=new HashMap<>();

        ZiyuanTableWithBLOBs sup = mapper.getUp(id);
        ZiyuanTableWithBLOBs sdown = mapper.getDown(id);
        map.put("upitem",sup);
        map.put("downitem",sdown);
        return map;
    }

    public int getCount(){
        ZiyuanTableExample e = new ZiyuanTableExample();
        int count = mapper.countByExample(e);
        return count;
    }
}
