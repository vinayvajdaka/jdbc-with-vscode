package UpadetandDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
 PreparedStatement ps= con.prepareStatement("delete from register where password='vinay123'");
 int i=ps.executeUpdate();
 if(i>0){
    System.out.println("Deletion successfull");

 }
 else{
    System.out.println("Error occurd");
 }

    }
    
}
