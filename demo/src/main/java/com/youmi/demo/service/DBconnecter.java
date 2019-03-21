package com.youmi.demo.service;


import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author sucre chen 906509023@qq.com
 * @Title: DBconnect
 * @Package
 * @Description:
 * @date 2019-03-20 14:01
 */

@Service
public class DBconnecter {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://10.0.1.55:3306/youmi","root","youmi1989");
        return conn;
    }
}
