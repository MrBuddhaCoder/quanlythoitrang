package control.delControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.quanService;

public class quanDelController {
	@FXML
	private Button myButton;

	@FXML
	private Label myLabel;

	@FXML
	private TextField myTextBox;

	int ma;

	@FXML
	void delButton(ActionEvent event) {

		ma = Integer.parseInt(myTextBox.getText());
		quanService.delQuan(ma);

	}
}
