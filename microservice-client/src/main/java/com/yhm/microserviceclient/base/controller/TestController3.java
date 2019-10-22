package com.yhm.microserviceclient.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("/aaa")
public class TestController3 {
    //@Value("spring.datasource.druid.ora8")
    //private DruidDataSourceProperties ora8_properties;

    @Autowired
    @Qualifier("ora8_ds")
    DataSource dataSource_ora8;
    @Autowired
    @Qualifier("ssaln_ds")
    DataSource dataSource_ssaln;

    @RequestMapping("/asd")
    public void t() throws SQLException, InterruptedException {
        //Properties properties1 = druidDataSourceProperties_ora8.toProperties();
        Connection conn = dataSource_ssaln.getConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from tcmcs001");
        ResultSet rs = pstm.executeQuery();
        //Thread.sleep(1000*10);
        if(rs.next()){
            System.out.println(rs.getString(1));
        }
        conn.close();
        System.out.println("asd");

    }


}
