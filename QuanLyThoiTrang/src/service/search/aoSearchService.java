package service.search;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.aoModel;
import service.search.list.aoSearch;

public class aoSearchService implements Initializable {
	@FXML
	private TableView<aoModel> aoTable;

	@FXML
	private TableColumn<aoModel, String> brandAoCol;

	@FXML
	private RadioButton idButton;

	@FXML
	private RadioButton loaiButton;

	@FXML
	private RadioButton mauSacButton;

	@FXML
	private RadioButton nhanButton;

	@FXML
	private TableColumn<aoModel, String> colorAoCol;

	@FXML
	private TableColumn<aoModel, Integer> idAocol;

	@FXML
	private TableColumn<aoModel, String> loaiAoCol;

	@FXML
	private TextField myTextField;

	int id;
	String textBox;
	//aggregation
	private List<aoModel> listAo;
	ObservableList<aoModel> listValueTableViewAo;

	@FXML
	void clickButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		textBox = myTextField.getText();
		if (textBox.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING, "không được để trống", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		if (idButton.isSelected()) {

			id = Integer.parseInt(myTextField.getText());
			listAo = aoSearch.searchListById(id);
		} else if (loaiButton.isSelected()) {
			listAo = aoSearch.searchListByLoaiAo(textBox);
		} else if (mauSacButton.isSelected()) {
			listAo = aoSearch.searchListByColor(textBox);
		} else if (nhanButton.isSelected()) {
			listAo = aoSearch.searchListByNhanHieu(textBox);
		} else {
			Alert alert = new Alert(AlertType.WARNING, "chưa check vào ô lựa chọn", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		listValueTableViewAo = FXCollections.observableArrayList(listAo);
		aoTable.setItems(listValueTableViewAo);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// phần hiển thị dữ liệu lên bảng
		idAocol.setCellValueFactory(new PropertyValueFactory<aoModel, Integer>("id"));
		loaiAoCol.setCellValueFactory(new PropertyValueFactory<aoModel, String>("loai_ao"));
		colorAoCol.setCellValueFactory(new PropertyValueFactory<aoModel, String>("color"));
		brandAoCol.setCellValueFactory(new PropertyValueFactory<aoModel, String>("brand"));

	}
}
