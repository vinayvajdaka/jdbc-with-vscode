package UpadetandDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpadateDemo {
    public static void main(String[] args) throws Exception {

        String name="vinay";
        String password="vinay8980";
        Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
        
    //  PreparedStatement pre= con.prepareStatement("update register set password='vinay4321' where name='vinay'");
    //  int i=pre.executeUpdate(); 
   PreparedStatement pre= con.prepareStatement("update register set password=? where name=?");
   pre.setString(1, password);
   pre.setString(2, name);

  int i= pre.executeUpdate();
if(i>0){
    System.out.println("Successfull");
}
else{
    System.out.println("Error occurd");
}

    }
    
}
