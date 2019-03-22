package com.youmi.demo.dao;

import com.youmi.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    //插入用户
    int insert(User user);
    //根据id查询
    User selectById(@Param("id") int id);
    //查询所有
    List<User> selectAll();

    //模糊查询
    List<User> searchByNick(@Param("nick")String nick);


}
