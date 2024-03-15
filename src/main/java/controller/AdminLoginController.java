package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {

    @FXML
    private Button btnLoginAdmin;

    @FXML
    private CheckBox checkboxPassword;

    @FXML
    private Label lblLgin;

    @FXML
    private Label lblpassword;

    @FXML
    private Label lblusername;

    @FXML
    private AnchorPane paneAdminLogin;

    @FXML
    private AnchorPane paneAdminLoginDetail;

    @FXML
    private TextField showPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginAdminController(ActionEvent event) throws IOException {
           // login();
     AnchorPane   anchorPane = FXMLLoader.load(getClass().getResource("/view/admin_dashbord.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) paneAdminLogin.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void checkBoxPasswordOnAction(ActionEvent event) {
if(checkboxPassword.isSelected()){
    showPassword.setText(txtPassword.getText());
    showPassword.setVisible(true);
    txtPassword.setVisible(false);
}
else{
    txtPassword.setText(showPassword.getText());
    txtPassword.setVisible(true);
    showPassword.setVisible(false);
}
    }
    /*Void login(){
        String userName=txtUserName.getText();
        String pswrd=txtPassword.getText();
        String pswrd1=showPassword.getText();
        try{

        }
    }*/



}