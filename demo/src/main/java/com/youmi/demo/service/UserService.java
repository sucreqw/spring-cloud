package com.youmi.demo.service;

import com.youmi.demo.dao.UserDao;
import com.youmi.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: UserService
 * @Package
 * @Description:
 * @date 2019-03-21 15:14
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getByUserId(int id ){
        return userDao.selectById(id);
    }
    //获取全部用户
    public List<User> getAll(){
        return userDao.selectAll();
    }


    public int insert(User user){
        return userDao.insert(user);
    }

    public List<User> search(String nick){
        return userDao.searchByNick(nick);
    }

}
