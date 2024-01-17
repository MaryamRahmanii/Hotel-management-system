import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        final String url="jdbc:mysql://localhost:3306/hotelsystem";
//        final String user="root";
//
//        Connection com;
//
//        {
//            try {
//                com = DriverManager.getConnection(url,user,null);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        String add="INSERT INTO guests(id,email,kodmeli,lastname,name,password)"+"VALUES(?,?,?,?,?,?)";
//
//        PreparedStatement pst=com.prepareStatement(add);
//
////        pst.setInt(1,3);
////        pst.setString(2,"maryam@gmail.com");
////        pst.setString(3,"2081177020");
////        pst.setString(4,"cherati");
////        pst.setString(5,"nima");
////        pst.setString(6,"78910");
////        pst.executeUpdate();
//
//        setTitle("Registration Form");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    new Hotel();

    }
}