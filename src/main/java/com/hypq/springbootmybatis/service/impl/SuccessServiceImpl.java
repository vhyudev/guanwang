package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.SuccessTableMapper;
import com.hypq.springbootmybatis.domain.SuccessTable;
import com.hypq.springbootmybatis.domain.SuccessTableExample;
import com.hypq.springbootmybatis.service.SuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuccessServiceImpl implements SuccessService {
    @Resource
    SuccessTableMapper mapper;

    @Override
    public List<SuccessTable> getAll() {
        SuccessTableExample e = new SuccessTableExample();
        List<SuccessTable> successTables = mapper.selectByExample(e);
        return successTables;
    }

    public int getCount(){
        SuccessTableExample e = new SuccessTableExample();
        int count = mapper.countByExample(e);
        return count;
    }
}
