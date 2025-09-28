package Control;

import Database.DBConnection;
import Model.User;

import java.sql.*;

public class UserController {

    public static boolean addUser(User user) throws SQLException, ClassNotFoundException {
        String SQL ="Insert into users(email,password_hash ) Values(?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,user.getEmail());
        stm.setObject(2,user.getPassword());
        return stm.executeUpdate()>0;

    }



    public static boolean resetPassword(String email,String password) throws SQLException, ClassNotFoundException {
        String SQL="Update users set password_hash = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setString(1, password);
        return stm.executeUpdate()>0;

    }

    public static boolean userExists(String email, String password) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT password_hash FROM users WHERE email = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setString(1, email);
        ResultSet rst = stm.executeQuery();

        if (rst.next()) { // move to the first row
            String storedPassword = rst.getString("password_hash"); // get password from DB
            return password.equals(storedPassword); // compare passwords
        }

        return false;
    }


}
