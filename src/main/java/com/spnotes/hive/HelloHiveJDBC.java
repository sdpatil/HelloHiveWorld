package com.spnotes.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by gpzpati on 4/26/14.
 */
public class HelloHiveJDBC {
    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    public static void main(String[] argv) throws Exception{
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        Connection connection = null;
        try {
           connection=  DriverManager.getConnection("jdbc:hive://172.16.225.188:10000/default", "", "");

            ResultSet resultSet = connection.createStatement().executeQuery("select * from records");

            while (resultSet.next()) {
                System.out.println(resultSet.getObject("year") + " " + resultSet.getObject("temperature"));
            }
        }finally{
            connection.close();
        }
    }
}
