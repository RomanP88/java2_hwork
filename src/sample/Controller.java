package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField;


    @FXML
    private TextArea textAria;

    @FXML
    public void clickBTNSend(ActionEvent actionEvent) {
        textAria.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
    @FXML
    public void clickBtn1(ActionEvent actionEvent) {
        textAria.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
}
