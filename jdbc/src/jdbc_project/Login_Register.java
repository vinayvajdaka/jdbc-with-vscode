package jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Login_Register {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Dreamyuga");
      Scanner sc=new Scanner(System.in);
int ch=0,i=0;
String name,pass,email,city,gen,valid_name,valid_pass;
PreparedStatement ps;
ResultSet res;
      do{
        System.out.println("1. LOGIN");
        System.out.println("2. REGISTER");
        System.out.println("3.CHANGE PASSWORD");
        System.out.println("4. DELETE USER");
        System.out.println("5. EXIT");
        try{
        System.out.print("Enter your choice :");
        ch=sc.nextInt();
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            break;
        }

        switch(ch){
            case 1:
            System.out.print("Enter user name :");
            name=sc.next();

           ps= con.prepareStatement("select * from register where name='"+name+"'");
           res=ps.executeQuery();
            valid_name="NUll";
           valid_pass="NUll";
          while(res.next())
          {
            valid_name=res.getNString("name");
            valid_pass=res.getNString("password");
          }
           if(name.equalsIgnoreCase(valid_name)){
            System.out.print("Enter password :");
            pass=sc.next();
            if(pass.equalsIgnoreCase(valid_pass)){
              ps= con.prepareStatement("select * from register where name='"+name+"'");
              res=ps.executeQuery();
                System.out.println("-----Welcome-----");
              while(res.next()){
                System.out.println("Name :"+res.getNString("name"));
                System.out.println("Email :"+res.getNString("email"));
                System.out.println("Gender :"+res.getNString("gender"));
                System.out.println("city :" +res.getNString("city"));
               
              }
              System.out.println("-----------------");
            }
            else{
              System.out.println("-----------------");
              System.out.println("Wrong Password");
              System.out.println("-----------------");
              continue;
            }
           }
           else{
            System.out.println("-----------------");
            System.out.println("User Not found");
            System.out.println("-----------------");
            continue;
           }
           break;


           case 2:
           System.out.print("Enter name :");
           name=sc.next();

           System.out.print("Enter email :");
           email=sc.next();

           System.out.print("Enter password :");
           pass=sc.next();

           System.out.print("Enter gender :");
           gen=sc.next();

           System.out.print("Enter city :");
           city=sc.next();

            ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, gen);
            ps.setString(5, city);

             i= ps.executeUpdate();

            if(i>0){
              System.out.println("-----------------");
              System.out.println("Register successfull");
              System.out.println("-----------------");
            }
            else{
              System.out.println("-----------------");
              System.out.println("Error occurd");
              System.out.println("-----------------");
            }
            break;


            case 3:
            System.out.print("Enter user name :");
            name=sc.next();
          
            ps= con.prepareStatement("select * from register where name='"+name+"'");
            res=ps.executeQuery();
             valid_name="NUll";
            valid_pass="NUll";
           while(res.next())
           {
             valid_name=res.getNString("name");
             valid_pass=res.getNString("password");
           }
            if(name.equalsIgnoreCase(valid_name)){
             System.out.print("Enter current password :");
             pass=sc.next();
             if(pass.equalsIgnoreCase(valid_pass)){
              System.out.print("Enter new password : ");
              pass=sc.next();
               ps= con.prepareStatement("update register set password='"+pass+"'where name='"+valid_name+"'");
              i= ps.executeUpdate();
              if(i>0){
                System.out.println("-----------------");
                System.out.println("Password change successfully");
                System.out.println("-----------------");
               
              }
              else{
                System.out.println("-----------------");
                System.out.println("Error occurd");
                System.out.println("-----------------");
              }
             }

             
             else{
               System.out.println("-----------------");
               System.out.println("Wrong Password");
               System.out.println("-----------------");
               continue;
             }
            

            }
          
            else{
              System.out.println("-----------------");
              System.out.println("User Not Found");
              System.out.println("-----------------");
              continue;
            }
            break;


            case 4:
            System.out.print("Enter user name :");
            name=sc.next();
          
            ps= con.prepareStatement("select * from register where name='"+name+"'");
            res=ps.executeQuery();
             valid_name="NUll";
            valid_pass="NUll";
           while(res.next())
           {
             valid_name=res.getNString("name");
             valid_pass=res.getNString("password");
           }
            if(name.equalsIgnoreCase(valid_name)){
             System.out.print("Enter password :");
             pass=sc.next();
             if(pass.equalsIgnoreCase(valid_pass)){
              
               ps= con.prepareStatement("delete  from register where name='"+valid_name+"'");
              i= ps.executeUpdate();
              if(i>0){
                System.out.println("-----------------");
                System.out.println("User Delete successfully");
                System.out.println("-----------------");
               
              }
              else{
                System.out.println("-----------------");
                System.out.println("Error occurd");
                System.out.println("-----------------");
              }
             }

             
             else{
               System.out.println("-----------------");
               System.out.println("Wrong Password");
               System.out.println("-----------------");
               continue;
             }
            

            }
          
            else{
              System.out.println("-----------------");
              System.out.println("User Not Found");
              System.out.println("-----------------");
              continue;
            }
            break;

            case 5:
            System.out.println("-----------------");
            System.out.println("GOOD BYE");
            System.out.println("-----------------");
            break;

        
            default:
            System.out.println("-----------------");
            System.out.println("unvalid choice");
            System.out.println("-----------------");


         
           
        }

     

    } while(ch!=5);
}

}
