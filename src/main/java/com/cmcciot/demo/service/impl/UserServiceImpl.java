package com.cmcciot.demo.service.impl;

import com.cmcciot.demo.dao.mapper.UserMapper;
import com.cmcciot.demo.dao.model.User;
import com.cmcciot.demo.model.PageInfo;
import com.cmcciot.demo.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map findAllUsers(int page, int size) {
        List<User> users = userMapper.selectAll((page - 1) * size, size);
        int count = userMapper.selectCount();

        PageInfo info = new PageInfo(count, page, size);

        Map data = new HashMap();
        data.put("pageInfo", info);
        data.put("users", users);

        return data;
    }
}
