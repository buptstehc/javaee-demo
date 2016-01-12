package com.cmcciot.demo.service;

import com.cmcciot.demo.dao.model.User;

/**
 * @Description
 * @Author Henry
 * @Date 16/1/12
 */
public interface UserService extends BaseService {

    User findById(Integer id);
}
