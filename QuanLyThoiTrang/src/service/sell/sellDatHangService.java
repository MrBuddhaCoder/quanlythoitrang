package service.sell;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.sell.orderHistoryModel;
import service.datHangService;

public class sellDatHangService implements Initializable {
	@FXML
	private TableColumn<orderHistoryModel, Integer> tableCol1;

	@FXML
	private TableColumn<orderHistoryModel, Integer> tableCol2;

	@FXML
	private TableColumn<orderHistoryModel, Integer> tableCol3;

	@FXML
	private TableColumn<orderHistoryModel, String> tableCol4;

	@FXML
	private TableView<orderHistoryModel> tableView;

	private List<orderHistoryModel> list;
	ObservableList<orderHistoryModel> listValueTableView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tableCol1.setCellValueFactory(new PropertyValueFactory<orderHistoryModel, Integer>("ao_id"));
		tableCol2.setCellValueFactory(new PropertyValueFactory<orderHistoryModel, Integer>("quan_id"));
		tableCol3.setCellValueFactory(new PropertyValueFactory<orderHistoryModel, Integer>("tui_xach_id"));
		tableCol4.setCellValueFactory(new PropertyValueFactory<orderHistoryModel, String>("order_date"));
		
		try {
			new datHangService();
			list = datHangService.getListDatHang();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listValueTableView = FXCollections.observableArrayList(list);
		tableView.setItems(listValueTableView);
	}

}
