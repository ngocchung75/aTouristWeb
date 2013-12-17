/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CHUNG TOOC
 */
public class ConnectDatabase {

    public java.sql.Connection Connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //Database Url to Mysql
        String dbUrl = "jdbc:mysql://localhost:3306/atourist_web";
        //String dbUrl = "jdbc:mysql://127.8.33.130:3306/atourist_web";

        //Database User Name
        String userName = "root";
        
        //Username server
        //String userName = "adminvxIzKGQ";

        //Database PassWord
        String passWord = "";
        
        //Pass server
        //String passWord = "UDbQJlDTemDQ";

        //Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/atourist_web?user=root&password=&useUnicode=true&characterEncoding=utf-8");
        Connection dbCon = DriverManager.getConnection(dbUrl, userName, passWord);
        return dbCon;
    }
}
