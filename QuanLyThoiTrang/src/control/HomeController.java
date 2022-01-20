package control;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.aoModel;
import model.quanModel;
import model.tuiXachModel;
import service.aoService;
import service.quanService;
import service.tuiXachService;
import service.thongke.thongKeService;

public class HomeController extends Application implements Initializable {
	protected static Session session = null;

	@FXML
	private Button aoButton;

	@FXML
	private TableView<aoModel> aoTable;

	@FXML
	private TextField endDateText;

	@FXML
	private TextField startDateText;

	@FXML
	private TableColumn<aoModel, Integer> idAocol;

	@FXML
	private TableColumn<quanModel, Integer> idQuanCol;

	@FXML
	private TableColumn<tuiXachModel, Integer> idTuiXachCol;

	@FXML
	private TableColumn<aoModel, String> loaiAoCol;

	@FXML
	private TableColumn<quanModel, String> loaiQuanCol;

	@FXML
	private TableColumn<tuiXachModel, String> loaiTuiXachCol;

	@FXML
	private Button sellButton11;

	@FXML
	private Button quanButton;

	@FXML
	private TableView<quanModel> quanTable;

	@FXML
	private TableColumn<aoModel, Integer> soLuongAoCol;

	@FXML
	private TableColumn<quanModel, Integer> soLuongQuanCol;

	@FXML
	private TableColumn<tuiXachModel, Integer> soLuongTuiXachCol;

	@FXML
	private Button thongKeButton;

	@FXML
	private Button timKiemButton;

	@FXML
	private Button trangChuButton;

	@FXML
	private Button sellButton1;

	@FXML
	private Button tuiXachButton;

	@FXML
	private Button sellButton111;

	@FXML
	private TableView<tuiXachModel> tuiXachTable;

	@FXML
	private TableColumn<aoModel, String> colorAoCol;
	@FXML
	private TableColumn<quanModel, String> colorQuanCol;
	@FXML
	private TableColumn<tuiXachModel, String> colorTuiXachCol;

	@FXML
	private TableColumn<aoModel, String> brandAoCol;
	@FXML
	private TableColumn<quanModel, String> brandQuanCol;
	@FXML
	private TableColumn<tuiXachModel, String> brandTuiXachCol;

	@FXML
	private Button sellButton;

	private List<tuiXachModel> listTuiXach;
	ObservableList<tuiXachModel> listValueTableViewTuiXach;

	private List<quanModel> listQuan;
	ObservableList<quanModel> listValueTableViewQuan;

	private List<aoModel> listAo;
	ObservableList<aoModel> listValueTableViewAo;

	@FXML
	void clickButton(ActionEvent event) throws ClassNotFoundException, SQLException {
		listAo = new aoService().getListAo();
		listValueTableViewAo = FXCollections.observableArrayList(listAo);
		aoTable.setItems(listValueTableViewAo);

		listQuan = new quanService().getListQuan();
		listValueTableViewQuan = FXCollections.observableArrayList(listQuan);
		quanTable.setItems(listValueTableViewQuan);

		listTuiXach = new tuiXachService().getListTuiXach();
		listValueTableViewTuiXach = FXCollections.observableArrayList(listTuiXach);
		tuiXachTable.setItems(listValueTableViewTuiXach);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//khi con trỏ chuột di chuyển vào 
		thongKeButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				thongKeButton.setText("4 sản phẩm chạy nhất");
			}

		});

		thongKeButton.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				thongKeButton.setText("Thống Kê");
			}
		});

		idAocol.setCellValueFactory(new PropertyValueFactory<aoModel, Integer>("id"));
		loaiAoCol.setCellValueFactory(new PropertyValueFactory<aoModel, String>("loai_ao"));
		colorAoCol.setCellValueFactory(new PropertyValueFactory<aoModel, String>("color"));
		brandAoCol.setCellValueFactory(new PropertyValueFactory<aoModel, String>("brand"));

		idQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, Integer>("id"));
		loaiQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, String>("loai_quan"));
		colorQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, String>("color"));
		brandQuanCol.setCellValueFactory(new PropertyValueFactory<quanModel, String>("brand"));

		idTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, Integer>("id"));
		loaiTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, String>("loai_tui_xach"));
		colorTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, String>("color"));
		brandTuiXachCol.setCellValueFactory(new PropertyValueFactory<tuiXachModel, String>("brand"));

		try {
			listAo = new aoService().getListAo();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listValueTableViewAo = FXCollections.observableArrayList(listAo);
		aoTable.setItems(listValueTableViewAo);

		try {
			listQuan = new quanService().getListQuan();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listValueTableViewQuan = FXCollections.observableArrayList(listQuan);
		quanTable.setItems(listValueTableViewQuan);

		try {
			listTuiXach = new tuiXachService().getListTuiXach();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listValueTableViewTuiXach = FXCollections.observableArrayList(listTuiXach);
		tuiXachTable.setItems(listValueTableViewTuiXach);

	}

	@FXML
	void aoButtonAction(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/view/select/aoSelectView.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setResizable(false);
		stage.showAndWait();
	}

	@FXML
	void quanButtonAction(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/view/select/quanSelectView.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setResizable(false);
		stage.showAndWait();
	}

	@FXML
	void tuiXachButtonAction(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/view/select/tuiXachSelectView.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setResizable(false);
		stage.showAndWait();
	}

	@FXML
	void clickSellButton(ActionEvent event) throws IOException {

		Parent home = FXMLLoader.load(getClass().getResource("/view/sell/orderAo.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(home));
		stage1.show();
	}

	@FXML
	void clickSellButton1(ActionEvent event) throws IOException {

		Parent home = FXMLLoader.load(getClass().getResource("/view/sell/orderQuan.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(home));
		stage1.show();
	}

	@FXML
	void clickSellButton11(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/view/sell/orderTuiXach.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(home));
		stage1.show();
	}

	@FXML
	void clickSellButton111(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/view/sell/DatHang.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(home));
		stage1.show();
	}

	@FXML
	void clickTimKiemButton(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/view/select/timKiemSelectView.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(home));
		stage1.show();
	}

	@FXML
	void thongKeButton(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, ParseException {
		List<aoModel> listAoThongKe = new ArrayList<>();
		ObservableList<aoModel> listValueTableViewAoThongKe;

		List<quanModel> listQuanThongKe = new ArrayList<>();
		ObservableList<quanModel> listValueTableViewQuanThongKe;

		List<tuiXachModel> listTuiXachThongKe = new ArrayList<>();
		ObservableList<tuiXachModel> listValueTableViewTuiXachThongKe;

		thongKeService.getList(startDateText.getText(), endDateText.getText());

		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		for (Integer i : thongKeService.listAo) {
			aoModel ao = session.get(aoModel.class, i);
			listAoThongKe.add(ao);
		}

		listValueTableViewAoThongKe = FXCollections.observableArrayList(listAoThongKe);
		aoTable.setItems(listValueTableViewAoThongKe);

		transaction.commit();
		session.close();

		// them tuixach

		session = tuiXachService.tuiXachModelConfig();
		transaction = session.beginTransaction();
		for (Integer i : thongKeService.listTuiXach) {
			System.out.println(i);
			tuiXachModel tuixach = session.get(tuiXachModel.class, i);
			listTuiXachThongKe.add(tuixach);
		}

		System.out.println(listTuiXachThongKe);

		listValueTableViewTuiXachThongKe = FXCollections.observableArrayList(listTuiXachThongKe);
		tuiXachTable.setItems(listValueTableViewTuiXachThongKe);

		transaction.commit();
		session.close();

		// them quan
		session = quanService.quanModelConfig();
		transaction = session.beginTransaction();
		for (Integer i : thongKeService.listQuan) {
			quanModel quan = session.get(quanModel.class, i);
			listQuanThongKe.add(quan);
		}

		listValueTableViewQuanThongKe = FXCollections.observableArrayList(listQuanThongKe);
		quanTable.setItems(listValueTableViewQuanThongKe);

		transaction.commit();
		session.close();

	}

	@Override
	public void start(Stage arg0) throws Exception {

	}

}
