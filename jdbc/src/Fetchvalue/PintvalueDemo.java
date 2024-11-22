package Fetchvalue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PintvalueDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
        PreparedStatement ps= con.prepareStatement("select * from register");
      ResultSet rs=  ps.executeQuery();
      while(rs.next()){
        System.out.print(rs.getString("name")+"  ");
        System.out.print(rs.getString("email")+"  ");
        System.out.print(rs.getString("password")+"  ");
        System.out.print(rs.getString("gender")+"  ");
        System.out.print(rs.getString("city")+"  ");
        System.out.println(" ");
      }

con.close();
    }
    
}
