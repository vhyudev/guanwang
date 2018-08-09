package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.User;

import java.util.List;

public interface UserService {
    User getUser();

    List<User> getAll();
}
