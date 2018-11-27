package com.hypq.springbootmybatis.service;


import com.hypq.springbootmybatis.domain.UserTable;

import java.util.List;

public interface UserService {

    UserTable getByUsername(String username) ;
}
