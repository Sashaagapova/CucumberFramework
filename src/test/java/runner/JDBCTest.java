package runner;

import utilities.Configuration;
import utilities.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    // Java database Connectivity

    public static void main(String[] args) throws IOException, SQLException {
       // connection
       // statement
       // ResultSet

        Connection connection= DriverManager.getConnection(
                Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));

        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery("Select * from employees");
        System.out.println(resultSet.getRow());
       resultSet.next();
       resultSet.next();
       resultSet.next();

        String myFirstData=resultSet.getString("FIRST_NAME");
        System.out.println(myFirstData);
        resultSet.next();
        System.out.println(resultSet.getObject("FIRST_NAME"));
        resultSet.next();
        System.out.println(resultSet.getObject("employee_ID"));
        System.out.println(resultSet.getRow());

        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        // resultSet is an object for a data from table
        System.out.println("-----------");
        System.out.println(rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(5));
        System.out.println(rsMetaData.getColumnType(5));
        System.out.println(rsMetaData.getColumnClassName(4));


        List<Map<String, Object>> listOfMaps= new ArrayList<>();
        resultSet.next();
        while (resultSet.next()){
            Map<String, Object> row = new HashMap<>();
            for(int i=1; i<=rsMetaData.getColumnCount();i++) {
                row.put(rsMetaData.getColumnName(i),resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            listOfMaps.add(row);
        }
        for(int i=0; i<listOfMaps.size(); i++){
            for(String key:listOfMaps.get(i).keySet()){
                System.out.println(listOfMaps.get(i).get(key));
            }
        }



    }




}
