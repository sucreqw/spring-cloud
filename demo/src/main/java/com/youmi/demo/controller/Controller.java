package com.youmi.demo.controller;

import com.youmi.demo.domain.OpenFeign;
import com.youmi.demo.service.DBconnecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: Controller
 * @Package
 * @Description:
 * @date 2019-03-14 10:59
 */
@RestController
public class Controller {


    @Autowired
    OpenFeign openFeign;
    @Autowired
    DBconnecter dBconnecter;

    @GetMapping("/demo")
    public String feign() {
        return "通过demo调用demo1:" + openFeign.test();
    }

    @GetMapping("/zuul")
    public String testZuul() {

        return "8084";
    }

    @GetMapping("/testsql")
    public boolean testSQL() {
        Connection conn = null;
        try {
            conn = dBconnecter.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            //4.处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
                System.out.println(rs.getString("nick") + " "
                        + rs.getString("pass"));
            }

            //关闭资源
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn == null ? false : true;
    }
}
