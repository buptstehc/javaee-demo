package com.cmcciot.demo.dao.mapper;

import com.cmcciot.demo.dao.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll(@Param("start")int start, @Param("size")int size);

    int selectCount();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}