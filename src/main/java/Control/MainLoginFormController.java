package Control;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainLoginFormController {
    public TextField txtEmail;
    public PasswordField txtPassword;
    public Button btnLogin;
    public Label lblReset;
    public Label lblNew;

    public void actionLogin(ActionEvent actionEvent) {
        System.out.println("success");
    }

    public void clickedReset(MouseEvent mouseEvent) {
        System.out.println("Reset");
    }

    public void clickedNew(MouseEvent mouseEvent) {
        System.out.println("New");
    }
}
