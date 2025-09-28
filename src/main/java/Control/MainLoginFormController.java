package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLoginFormController {
    public TextField txtEmail;
    public PasswordField txtPassword;
    public Button btnLogin;
    public Label lblReset;
    public Label lblNew;

    public void actionLogin(ActionEvent actionEvent) {
        System.out.println("success");
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
