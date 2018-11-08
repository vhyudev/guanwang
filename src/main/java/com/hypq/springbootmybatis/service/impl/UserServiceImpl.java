package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.UserMapper;
import com.hypq.springbootmybatis.domain.User;
import com.hypq.springbootmybatis.domain.UserExample;
import com.hypq.springbootmybatis.service.UserService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.stereotype.Service;
import com.hypq.springbootmybatis.domain.UserExample.Criteria;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;

    @Override
    public User getUser() {
        return mapper.selectByPrimaryKey("1");
    }

    @Override
    public List<User> getAll() {
        UserExample example = new UserExample();
        return mapper.selectByExample(example);

    }
}
