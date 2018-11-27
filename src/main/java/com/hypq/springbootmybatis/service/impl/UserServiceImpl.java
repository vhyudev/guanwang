package com.hypq.springbootmybatis.service.impl;


import com.hypq.springbootmybatis.dao.UserTableMapper;
import com.hypq.springbootmybatis.domain.UserTable;
import com.hypq.springbootmybatis.domain.UserTableExample;
import com.hypq.springbootmybatis.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserTableMapper mapper;


    @Override
    public UserTable getByUsername(String username) {
        UserTableExample e = new UserTableExample();
        UserTableExample.Criteria criteria = e.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UserTable> userTables = mapper.selectByExample(e);
        if (userTables.size()==0){
            return null;
        }
        return userTables.get(0);
    }
}
