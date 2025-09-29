package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainLoginFormController {
    public TextField txtEmail;
    public PasswordField txtPassword;
    public Button btnLogin;
    public Label lblReset;
    public Label lblNew;


    public void actionLogin(ActionEvent actionEvent) {
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both email and password.");
            alert.showAndWait();
            return;
        }

        try {
            boolean loginSuccess = UserController.userExists(email, password);

            Alert alert = new Alert(loginSuccess ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
            alert.setTitle("Login Status");
            alert.setHeaderText(null);
            alert.setContentText(loginSuccess ? "Login Success!" : "Invalid email or password.");
            alert.showAndWait();

            if (loginSuccess) {
                // Optionally, navigate to the next page here
            } else {
                txtPassword.clear();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("An error occurred while accessing the database. Please try again.");
            alert.showAndWait();
        }
    }


    Stage resetStage=new Stage();

    public void clickedReset(MouseEvent mouseEvent) {
        Stage stage = (Stage) lblReset.getScene().getWindow();
        stage.close();


        try {
            resetStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/ResetPasswordForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        resetStage.show();
    }

    Stage newStage=new Stage();
    public void clickedNew(MouseEvent mouseEvent) {
        Stage stage = (Stage) lblNew.getScene().getWindow();
        stage.close();
        try {
            newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/NewAccountForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.show();
    }
}
