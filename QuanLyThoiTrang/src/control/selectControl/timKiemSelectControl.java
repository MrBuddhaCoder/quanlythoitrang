package control.selectControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class timKiemSelectControl implements Initializable {
	@FXML
	private Button myButton;

	@FXML
	private ChoiceBox<String> myChoiceBox;

	String[] select = { "ÁO", "QUẦN", "TÚI XÁCH", "THEO THÁNG BÁN" };

	@FXML
	void clickButton(ActionEvent event) throws IOException {
		String mySelect = myChoiceBox.getValue();
		if (mySelect.equals("ÁO")) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();

			Parent home = FXMLLoader.load(getClass().getResource("/view/search/aoSearchView.fxml"));
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(home));
			stage1.show();
		}
		if (mySelect.equals("QUẦN")) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();

			Parent home = FXMLLoader.load(getClass().getResource("/view/search/quanSearchView.fxml"));
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(home));
			stage1.show();
		}
		if (mySelect.equals("TÚI XÁCH")) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();

			Parent home = FXMLLoader.load(getClass().getResource("/view/search/tuiXachSearchView.fxml"));
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(home));
			stage1.show();
		}
		if (mySelect.equals("THEO THÁNG BÁN")) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();

			Parent home = FXMLLoader.load(getClass().getResource("/view/search/theoThangSearchView.fxml"));
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(home));
			stage1.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoiceBox.getItems().addAll(select);

	}
}
