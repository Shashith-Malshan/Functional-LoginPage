package Control;

import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
    User user=new User(txtEmail.getText().trim(),txtPassword.getText().trim());
        try {
            boolean isAdded=UserController.addUser(user);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Customer added successfully!");
                alert.showAndWait();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
