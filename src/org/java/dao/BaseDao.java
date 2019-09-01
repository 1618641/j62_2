package org.java.dao;

/**
 * @Author: 马果
 * @Date: 2019/8/23 10:24
 * @Description:
 */

import java.sql.*;

public class BaseDao {

    protected Connection con;

    protected CallableStatement cst;

    protected ResultSet rs;


    protected Connection getConn() throws ClassNotFoundException, SQLException {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection(url, "j64", "j64");

        return con;
    }

    protected void close() throws SQLException {
        if(rs!=null)rs.close();
        if(cst!=null)cst.close();
        if(con!=null)con.close();;
    }

}
