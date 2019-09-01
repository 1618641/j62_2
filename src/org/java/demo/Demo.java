package org.java.demo;

import org.java.dao.InfDao;

import java.sql.SQLException;

/**
 * @Author: 马果
 * @Date: 2019/8/23 10:35
 * @Description:
 */
public class Demo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        InfDao dao = new InfDao();
       // dao.add(3,"mariah" ,77 );
       // dao.show(1);
        dao.findAll(90);

    }
}
