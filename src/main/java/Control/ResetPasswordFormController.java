package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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
