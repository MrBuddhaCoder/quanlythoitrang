package service.search;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tuiXachModel;
import service.search.list.tuiXachSearch;

public class tuiXachSearchService implements Initializable {
	@FXML
	private TableColumn<tuiXachModel, String> brandTuiXachCol;

	@FXML
	private Button button;

	@FXML
	private RadioButton idButton;

	@FXML
	private RadioButton loaiButton;

	@FXML
	private RadioButton mauSacButton;

	@FXML
	private RadioButton nhanButton;

	@FXML
	private ChoiceBox<String> choiceBox;

	@FXML
	private ChoiceBox<String> choiceBox1;

	@FXML
	private ChoiceBox<String> choiceBox2;

	@FXML
	private TableColumn<tuiXachModel, String> colorTuiXachCol;

	@FXML
	private TableColumn<tuiXachModel, Integer> idTuiXachCol;

	@FXML
	private TableColumn<tuiXachModel, String> loaiTuiXachCol;

	@FXML
	private TextField myTextField;

	@FXML
	private TableView<tuiXachModel> tuiXachTable;

	int id;
	String textBox;

	private List<tuiXachModel> listTuiXach;
	ObservableList<tuiXachModel> listValueTableViewTuiXach;

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
			listTuiXach = tuiXachSearch.searchListById(id);
		} else if (loaiButton.isSelected()) {
			listTuiXach = tuiXachSearch.searchListByType(textBox);
		} else if (mauSacButton.isSelected()) {
			listTuiXach = tuiXachSearch.searchListByColor(textBox);
		} else if (nhanButton.isSelected()) {
			listTuiXach = tuiXachSearch.searchListByBrand(textBox);
		} else {
			Alert alert = new Alert(AlertType.WARNING, "chưa check vào ô lựa chọn", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		listValueTableViewTuiXach = FXCollections.observableArrayList(listTuiXach);
		tuiXachTable.setItems(listValueTableViewTuiXach);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		idTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, Integer>("id"));
		loaiTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, String>("loai_tui_xach"));
		colorTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, String>("color"));
		brandTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, String>("brand"));
	}

}
