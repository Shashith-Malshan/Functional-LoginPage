package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAccountFormController {
    public TextField txtEmail;
    public Label lblEmail;
    public PasswordField txtPassword;
    public Button btnCreate;
    public Label lblLog;
    public Button btnGetOtp;
    public TextField txtOtp;
    public Label lblResend;
    public CheckBox checkLogged;

    public void actionCreate(ActionEvent actionEvent) {
    }

    Stage primaryStage=new Stage();
    public void clickedLog(MouseEvent mouseEvent) {
        Stage stage=(Stage)lblLog.getScene().getWindow();
        stage.close();

        try {
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/MainLoginForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.show();
    }

    public void actionGetOtp(ActionEvent actionEvent) {
    }

    public void clickedResend(MouseEvent mouseEvent) {
    }
}
