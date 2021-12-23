import java.sql.*;

public class userDAO {
    public void insertUser(Connection con,int id,String first_name,String last_name,String email) throws SQLException {
        String query="insert into user1(id,first_name,last_name,email) values(?,?,?,?)";
        PreparedStatement psts=con.prepareStatement(query);
        psts.setInt(1,id);
        psts.setString(2,first_name);
        psts.setString(3,last_name);
        psts.setString(4,email);
        int row= psts.executeUpdate();


    }
    public void updateUser(Connection con,String first_name,String last_name,String email,int id) throws SQLException {
        String query;
        int row;
        PreparedStatement psts;
        query = "update user1 set first_name=?,last_name=?,email=? where id=?";
        psts = con.prepareStatement(query);
        psts.setString(1, first_name);
        psts.setString(2, last_name);
        psts.setString(3, email);
        psts.setInt(4,id);
        row = psts.executeUpdate();

    }

    public void displayUser(Statement stmt) throws SQLException {
        String query="select * from user1";
        ResultSet rs=stmt.executeQuery(query);
        int rowCouner=0;
        while (rs.next()){
            int id=rs.getInt("id");
            String first_name=rs.getString("first_name");
            String last_name=rs.getString("last_name");
            String email=rs.getString("email");
            System.out.println("The Data : Id= "+ id+", First Name = "+first_name + ", Last Name = "+last_name + ", Email ="+email);


        }

    }
    public void deleteUser(Connection con,int id) throws SQLException {
        String query="delete from user1 where id=?";
        PreparedStatement psts=con.prepareStatement(query);
        psts.setInt(1,id);
        int row= psts.executeUpdate();
    }
}
