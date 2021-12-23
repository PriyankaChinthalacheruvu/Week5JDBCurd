import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            userDAO userdao=new userDAO();

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database", "root", "root");
            Statement stmt = con.createStatement();
            int num;

            do{
                System.out.println("welcome to User CRUD Services...!!!");
                System.out.println("1.Register");
                System.out.println("2.Update");
                System.out.println("3.Display");
                System.out.println("4.Delete");
                System.out.println("0.Exit");
                Scanner scan = new Scanner(System.in);
                num=scan.nextInt();

                switch (num) {
                    case 1:
                        Scanner sc=new Scanner(System.in);
                        System.out.println("Enter the user Id: ");
                        int Id=sc.nextInt();
                        System.out.println("Enter the user First name: ");
                        String First_name=sc.next();
                        System.out.println("Enter the user Second or Last name: ");
                        String Last_name=sc.next();
                        System.out.println("Enter the user Email: ");
                        String Email=sc.next();
                        userdao.insertUser(con,Id,First_name,Last_name,Email);
                        break;
                    case 2:
                        Scanner s1=new Scanner(System.in);
                        System.out.println("Enter the user ID you want to update");
                        int id1=s1.nextInt();
                        System.out.println("Enter the user first name to update");
                        String str1=s1.next();
                        System.out.println("Enter the user last name update");
                        String str2=s1.next();
                        System.out.println("Enter the user email to update");
                        String str3=s1.next();
                        userdao.updateUser(con,str1,str2,str3,id1);
                        break;
                    case 3:
                        userdao.displayUser(stmt);
                        break;
                    case 4:
                        Scanner s=new Scanner(System.in);
                        int Id1= s.nextInt();
                        userdao.deleteUser(con,Id1);
                        break;
                    case 5:
                        con.close();
                        break;
                }
            }
            while (num>0);
            }catch(Exception e){
                e.printStackTrace();

            }



    }
}
