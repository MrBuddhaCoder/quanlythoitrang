package control.AddModifyControl;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.aoModel;
import service.aoService;

public class aoController implements Initializable {
	@FXML
	private Button button;

	@FXML
	private ChoiceBox<String> choiceBox;

	@FXML
	private ChoiceBox<String> choiceBox1;

	@FXML
	private TextField myTextField;

	@FXML
	private ChoiceBox<String> choiceBox2;

	private String[] loaiAo = { "dài áo", "rộng áo", "dài tay", "rộng tay" };
	private String[] mauSac = { "xanh", "đỏ" };
	private String[] nhanhieu = { "A", "B" };

	int id;

	@FXML
	void clickButton(ActionEvent event) throws ClassNotFoundException, SQLException {
		List<aoModel> aoList = aoService.getListAo();
		// mã nhập vào phải lớn hơn 0
		if (Integer.parseInt(myTextField.getText()) <= 0) {
			Alert alert = new Alert(AlertType.WARNING, "mã ID không hợp lệ", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		id = Integer.parseInt(myTextField.getText());
		if (button.getText().equals("sửa")) {
			aoService.modifyAo(id, myAo, myMauSac, myNhanHieu);
		} else {
			// kiểm tra trùng
			for (aoModel ao : aoList) {
				if (ao.getId() == Integer.parseInt(myTextField.getText())) {
					Alert alert = new Alert(AlertType.WARNING, "trùng ID", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					return;
				}
			}

			aoService.addAo(id, myAo, myMauSac, myNhanHieu);

		}
	}

	String myAo;
	String myMauSac;
	String myNhanHieu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceBox.getItems().addAll(loaiAo);

		choiceBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				myAo = choiceBox.getValue();
			}

		});

		choiceBox1.getItems().addAll(mauSac);

		choiceBox1.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				myMauSac = choiceBox1.getValue();
			}

		});

		choiceBox2.getItems().addAll(nhanhieu);

		choiceBox2.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				myNhanHieu = choiceBox2.getValue();
			}

		});

	}
}
