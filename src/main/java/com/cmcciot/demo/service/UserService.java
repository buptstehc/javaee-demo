package com.cmcciot.demo.service;

import com.cmcciot.demo.dao.model.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.Map;

/**
 * @Description
 * @Author Henry
 * @Date 16/1/12
 */
@Validated
public interface UserService extends BaseService {

    User findById(Integer id);

    Map findAllUsers(@Min(value = 1, message = "page must be greater than 0") int page,
                     int size);
}
