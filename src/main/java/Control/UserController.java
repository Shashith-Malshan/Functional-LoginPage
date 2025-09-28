package Control;

import Database.DBConnection;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {

    public static boolean addUser(User user) throws SQLException, ClassNotFoundException {
        String SQL ="Insert into users(email,password_hash ) Values(?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,user.getEmail());
        stm.setObject(2,user.getPassword());
        return stm.executeUpdate()>0;

    }
    /*
    public static User searchUser(){

    }
    public static boolean updateUser(){

    }*/


}
