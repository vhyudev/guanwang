package com.hypq.springbootmybatis.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.hypq.springbootmybatis.dao.LunbotuTableMapper;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.domain.LunbotuTableExample;
import com.hypq.springbootmybatis.service.LunboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LunboServiceImpl implements LunboService {
   @Resource
    LunbotuTableMapper mapper;

    @Override
    public List<LunbotuTable> getItems() {
        return mapper.selectByExample(new LunbotuTableExample());
    }

    @Override
    public int getCount() {
        return mapper.countByExample(new LunbotuTableExample());
    }

    @Override
    public void addLunbotu(LunbotuTable lunbotu) {
        if(StringUtils.isEmpty(lunbotu.getId())){
            UUID uuid = UUID.randomUUID();
            lunbotu.setId(uuid.toString().replaceAll("-",""));
            mapper.insert(lunbotu);
        }else {
            LunbotuTableExample e = new LunbotuTableExample();
            LunbotuTableExample.Criteria c = e.createCriteria();
            c.andIdEqualTo(lunbotu.getId());
            mapper.updateByExampleSelective(lunbotu,e);
        }



    }

    @Override
    public void deleteLunbotu(String id) {
        LunbotuTableExample e = new LunbotuTableExample();
        LunbotuTableExample.Criteria c = e.createCriteria();
        c.andIdEqualTo(id);
        mapper.deleteByExample(e);
    }
}
