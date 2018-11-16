package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.SuccessTableMapper;
import com.hypq.springbootmybatis.domain.SuccessTable;
import com.hypq.springbootmybatis.domain.SuccessTableExample;
import com.hypq.springbootmybatis.service.SuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.util.UIUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SuccessServiceImpl implements SuccessService {
    @Resource
    SuccessTableMapper mapper;

    @Override
    public List<SuccessTable> getAll() {
        SuccessTableExample e = new SuccessTableExample();
        List<SuccessTable> successTables = mapper.selectByExample(e);
        return successTables;
    }

    @Override
    public void addSuccess(SuccessTable st) {
        Integer id = st.getId();

        if(id==null){
            mapper.insert(st);
        }else {
            SuccessTableExample e = new SuccessTableExample();
            e.createCriteria().andIdEqualTo(st.getId());
            mapper.updateByExampleSelective(st,e);
        }

    }

    @Override
    public List<SuccessTable> getSuccessItems() {
        return mapper.selectByExample(new SuccessTableExample());
    }

    @Override
    public void deleteSuccessCase(String id) {
        mapper.deleteByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public SuccessTable getSuccessById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int getCount(){
        SuccessTableExample e = new SuccessTableExample();
        int count = mapper.countByExample(e);
        return count;
    }
}
