package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.LiuyanTableMapper;
import com.hypq.springbootmybatis.domain.LiuyanTable;
import com.hypq.springbootmybatis.domain.LiuyanTableExample;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.service.LiuyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LiuyanServiceImpl implements LiuyanService {
    @Resource
    LiuyanTableMapper mapper;
    @Override
    public void addliuyan(LiuyanTable liuyan) {
        mapper.insert(liuyan);
    }

    @Override
    public List<LiuyanTable> getItems() {
        return mapper.selectByExample( new LiuyanTableExample());
    }

    @Override
    public int getCount() {
        return mapper.countByExample(new LiuyanTableExample());
    }

    @Override
    public void deleteLiuyan(String id) {
        mapper.deleteByPrimaryKey(Integer.valueOf(id));
    }
}
