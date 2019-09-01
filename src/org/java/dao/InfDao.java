package org.java.dao;

import oracle.jdbc.OracleTypes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 马果
 * @Date: 2019/8/23 10:30
 * @Description:
 */
public class InfDao extends BaseDao {


    public void findAll(int score) throws SQLException, ClassNotFoundException {

        String sql ="{call my_pc(?,?)}";
        cst = getConn().prepareCall(sql);
        cst.registerOutParameter(1,OracleTypes.CURSOR );
        cst.setObject(2,score );

        cst.executeUpdate();

        rs=(ResultSet) cst.getObject(1);//得到查询存储过程，返回来的游标(Resultset)

        while(rs.next()){
            String name = rs.getString("name");
            String clazz = rs.getString("class");
            int myscore = rs.getInt("score");

            System.out.println(name+"===="+clazz+"  "+myscore);

        }
        close();
    }




    /**
     * 根据条件，查询数据的存储过程
     */
    public void show(int id) throws SQLException, ClassNotFoundException {
        String sql = "{call my_pr(?,?,?)}";
        cst = getConn().prepareCall(sql);
        //注册输入参数
        cst.setObject(1, id);
        //注册输出参数 register
        cst.registerOutParameter(2, OracleTypes.VARCHAR);
        cst.registerOutParameter(3,OracleTypes.NUMBER );

        //执行存储过程
        cst.executeUpdate();

        //从cst中，获得返回的结果
        String name = cst.getString(2);
        Integer score = cst.getInt(3);

        System.out.println("姓名:"+name);
        System.out.println("成绩:"+score);
    }


    public void add(int id, String name, int score) throws SQLException, ClassNotFoundException {

        String sql = "{call my_pc(?,?,?)}";
        cst = getConn().prepareCall(sql);
        cst.setObject(1, id);
        cst.setObject(2, name);
        cst.setObject(3, score);

        //cst.executeUpdate();
        boolean flag = cst.execute();

        System.out.println(flag);
        System.out.println("执行成功..");
    }
}
