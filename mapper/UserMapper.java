package com.tom.mapper;

import com.tom.po.User;

import java.util.List;

public interface UserMapper {

    public int queryUserByCount(User user) throws Exception;

    public List<User> queryUserByAlias() throws Exception;
}
