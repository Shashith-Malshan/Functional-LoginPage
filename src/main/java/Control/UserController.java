package Control;

import Database.DBConnection;
import Model.User;
import Util.PasswordUtils;

import java.sql.*;

public class UserController {

    // Add user with hashed password
    public static boolean addUser(User user) throws SQLException, ClassNotFoundException {
        String SQL = "INSERT INTO users(email, password_hash) VALUES (?, ?)";
        PasswordUtils passwordUtils = new PasswordUtils();
        String hashedPassword = passwordUtils.hashPassword(user.getPassword());

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement stm = connection.prepareStatement(SQL)) {

            stm.setString(1, user.getEmail());
            stm.setString(2, hashedPassword);

            return stm.executeUpdate() > 0;
        }
    }

    // Reset password safely with hashing
    public static boolean resetPassword(String email, String newPassword) throws SQLException, ClassNotFoundException {
        String SQL = "UPDATE users SET password_hash = ? WHERE email = ?";
        PasswordUtils passwordUtils = new PasswordUtils();
        String hashedPassword = passwordUtils.hashPassword(newPassword);

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement stm = connection.prepareStatement(SQL)) {

            stm.setString(1, hashedPassword);
            stm.setString(2, email);

            return stm.executeUpdate() > 0;
        }
    }

    // Check user login
    public static boolean userExists(String email, String password) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT password_hash FROM users WHERE email = ?";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement stm = connection.prepareStatement(SQL)) {

            stm.setString(1, email);

            try (ResultSet rst = stm.executeQuery()) {
                if (rst.next()) {
                    String storedPassword = rst.getString("password_hash");
                    PasswordUtils passwordUtils = new PasswordUtils();
                    return passwordUtils.checkPassword(password, storedPassword);
                }
            }
        }
        return false;
    }
}
