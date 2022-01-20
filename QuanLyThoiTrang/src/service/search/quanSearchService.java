package service.search;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.quanModel;
import service.search.list.aoSearch;
import service.search.list.quanSearch;

public class quanSearchService implements Initializable {
	@FXML
	private TableColumn<quanModel, String> brandQuanCol;

	@FXML
	private Button button;

	@FXML
	private ChoiceBox<String> choiceBox;

	@FXML
	private ChoiceBox<String> choiceBox1;

	@FXML
	private ChoiceBox<String> choiceBox2;

	@FXML
	private TableColumn<quanModel, String> colorQuanCol;

	@FXML
	private TableColumn<quanModel, Integer> idQuanCol;

	@FXML
	private TableColumn<quanModel, String> loaiQuanCol;

	@FXML
	private TextField myTextField;

	@FXML
	private RadioButton idButton;

	@FXML
	private RadioButton loaiButton;

	@FXML
	private RadioButton mauSacButton;

	@FXML
	private RadioButton nhanButton;

	@FXML
	private TableView<quanModel> quanTable;

	int id;
	String textBox;

	private List<quanModel> listQuan;
	ObservableList<quanModel> listValueTableViewQuan;

	@FXML
	void clickButton(ActionEvent event) {
		textBox = myTextField.getText();
		if (textBox.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING, "không được để trống", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		if (idButton.isSelected()) {

			id = Integer.parseInt(myTextField.getText());
			listQuan = quanSearch.searchListById(id);
		} else if (loaiButton.isSelected()) {
			listQuan = quanSearch.searchListByLoaiQuan(textBox);
		} else if (mauSacButton.isSelected()) {
			listQuan = quanSearch.searchListByColor(textBox);
		} else if (nhanButton.isSelected()) {
			listQuan = quanSearch.searchListByBrand(textBox);
		} else {
			Alert alert = new Alert(AlertType.WARNING, "chưa check vào ô lựa chọn", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		listValueTableViewQuan = FXCollections.observableArrayList(listQuan);
		quanTable.setItems(listValueTableViewQuan);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		idQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, Integer>("id"));
		loaiQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, String>("loai_quan"));
		colorQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, String>("color"));
		brandQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, String>("brand"));
	}
}
