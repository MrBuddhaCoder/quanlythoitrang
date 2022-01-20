package service.search;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.datHangService;

public class theoThangSearch implements Initializable {
	@FXML
	private TextField monthText;

	@FXML
	private Button timKiemBut;

	@FXML
	private TableColumn<String, String> kichThuocCol;

	@FXML
	private TableView<String> kichThuocTable;

	private List<String> listTheoThang;
	ObservableList<String> listValueTableViewTheoThang;

	@FXML
	void clickTimKiemButton(ActionEvent event) throws SQLException {
		listTheoThang = datHangService.getListDatHangTheoThang(monthText.getText());
		List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listTheoThang));
		listValueTableViewTheoThang = FXCollections.observableArrayList(listWithoutDuplicates);
		// dùng simpleStringProperty
		kichThuocTable.setItems(listValueTableViewTheoThang);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		kichThuocCol.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
	}
}
