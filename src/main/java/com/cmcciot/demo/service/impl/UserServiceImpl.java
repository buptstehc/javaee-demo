package com.cmcciot.demo.service.impl;

import com.cmcciot.demo.dao.mapper.UserMapper;
import com.cmcciot.demo.dao.model.User;
import com.cmcciot.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 黄川
 * @Date 16/1/12
 */

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(Integer id) {
        logger.info("User:" + id);

        return userMapper.selectByPrimaryKey(id);
    }
}
