package Insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertvalue_byuser {
    public static void main(String[] args) throws Exception{
     Scanner sc= new Scanner(System.in);


       //loads the driver
       Class.forName("com.mysql.cj.jdbc.Driver");

       //build the connection
     Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
         
         String name,email,password,gender,city;
         int i=0;
         PreparedStatement pre;

         for(int j=0;j<5;j++){
            System.out.print("Enter your name : ");
            name =sc.next();

            System.out.print("Enter your Email :");
            email=sc.next();

            System.out.print("Enter your password :");
            password=sc.next();

            System.out.print("Enter your gender :");
            gender=sc.next();


            System.out.print("Enter your city :");
            city=sc.next();
            pre= con.prepareStatement("insert into register values('"+name+"','"+email+"','"+password+"','"+gender+"','"+city+"')");
           i= pre.executeUpdate();
      
            if(i>0){
              System.out.println("Insertion successfull");
              i=0;
            }
            else{
              System.out.println("Error uccured");
            }

         }
    


      

      //writting a query to insert value
     
    }

    
}
