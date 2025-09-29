package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ResetPasswordFormController {
    public TextField txtEmail;
    public PasswordField txtNewPassword;
    public Button btnSubmit;
    public Label lblBack;
    public PasswordField txtConfirmPassword;

    public void validateEmail(KeyEvent keyEvent) {
    }

    public void validateNewPassword(KeyEvent keyEvent) {
    }

    public void actionSubmit(ActionEvent actionEvent) {
        try {
            if(UserController.resetPassword(txtEmail.getText().trim(),txtConfirmPassword.getText().trim())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Util Changed");
                alert.showAndWait();

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    Stage primaryStage=new Stage();
    public void clickedBack(MouseEvent mouseEvent) {
        Stage stage=(Stage)lblBack.getScene().getWindow();
        stage.close();

        try {
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/MainLoginForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.show();
    }

    public void validateConfirmPassword(KeyEvent keyEvent) {
    }
}
