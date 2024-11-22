package Insert;
import java.sql.Connection;
import java.sql.DriverManager;

public class Create_Connection {
    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
        System.out.println("connection successfull");
        
    }
}
