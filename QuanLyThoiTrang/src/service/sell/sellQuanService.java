package service.sell;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.aoModel;
import model.quanModel;
import service.aoService;
import service.search.list.quanSearch;
import utils.sell.sellQuanUtils;

public class sellQuanService {
	@FXML
	private TextField aoIDText;

	@FXML
	private TextField orderDateText;

	@FXML
	private Button sellButton;

	private String order_date;
	private int ao_id;

	@FXML
	void sellButton(ActionEvent event) throws ClassNotFoundException, SQLException {
		order_date = orderDateText.getText();
		ao_id = Integer.parseInt(aoIDText.getText());

		// check id áo có tồn tại
		List<quanModel> listQuan = quanSearch.getListQuan();
		List<Integer> listId = new ArrayList<>();
		for (quanModel quan : listQuan) {
			listId.add(quan.getId());
		}
		if (!listId.contains(ao_id)) {
			Alert alert = new Alert(AlertType.WARNING, "không có ID này", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}

		sellQuanUtils.sell(order_date, ao_id);
	}
}
