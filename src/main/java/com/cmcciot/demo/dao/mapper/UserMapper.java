package com.cmcciot.demo.dao.mapper;

import com.cmcciot.demo.dao.model.User;

public interface UserMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}