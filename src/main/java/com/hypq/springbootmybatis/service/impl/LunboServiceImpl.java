package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.LunbotuTableMapper;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.domain.LunbotuTableExample;
import com.hypq.springbootmybatis.service.LunboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
}
