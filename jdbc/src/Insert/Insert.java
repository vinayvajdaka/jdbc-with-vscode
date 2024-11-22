package Insert;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Insert {


    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
        System.out.println("connection successfull");

        PreparedStatement ps= con.prepareStatement("insert into register values ('Vinay','vinay123@gmail.com','vinay123','male','ahemdabad')");
        int i=ps.executeUpdate();
        if(i>0){
            System.out.println("Successfull");
        }
        else{
            System.out.println("fail");
        }
    }
}


