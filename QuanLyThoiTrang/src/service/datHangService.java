package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.aoModel;
import model.quanModel;
import model.tuiXachModel;
import model.sell.orderHistoryModel;
import utils.ConnectionUtil;

public class datHangService {
	protected static Session session = null;

	public static List<orderHistoryModel> getListDatHang() throws ClassNotFoundException, SQLException {
		List<orderHistoryModel> list = new ArrayList<>();
		Connection connection = ConnectionUtil.conDB();
		String query = "SELECT order_date,ao_id,quan_id,tui_xach_id FROM order_history;";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			orderHistoryModel dathang = new orderHistoryModel(rs.getString("order_date"), rs.getInt("ao_id"),
					rs.getInt("quan_id"), rs.getInt("tui_xach_id"));
			list.add(dathang);
		}
		preparedStatement.close();
		connection.close();
		return list;
	}

	public static List<String> getListDatHangTheoThang(String thangBan) throws SQLException {
		int aoId, quanId, tuiXachId;
		List<String> listKichThuoc = new ArrayList<>();
		Connection connection = ConnectionUtil.conDB();
		String query = "SELECT ao_id,quan_id,tui_xach_id FROM order_history where order_date = '" + thangBan + "'";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		// getloai khi tồn tại bên quan hệ áo,quần,túi xách mới get được
		while (rs.next()) {
			// mỗi dòng mình update
			aoId = rs.getInt("ao_id");
			quanId = rs.getInt("quan_id");
			tuiXachId = rs.getInt("tui_xach_id");

			// check tồn tại
			// dòng có aoId
			if (aoId != 0) {
				session = aoService.aoModelConfig();
				Transaction transaction = session.beginTransaction();
				aoModel ao = session.get(aoModel.class, aoId);
				listKichThuoc.add(ao.getLoai_ao());
				transaction.commit();
				session.close();

			}
			// dòng có quanid
			if (quanId != 0) {
				session = quanService.quanModelConfig();
				Transaction transaction = session.beginTransaction();
				quanModel quan = session.get(quanModel.class, quanId);
				listKichThuoc.add(quan.getLoai_quan());
				transaction.commit();
				session.close();
			}
			// dòng có tuixachid
			if (tuiXachId != 0) {
				session = tuiXachService.tuiXachModelConfig();
				Transaction transaction = session.beginTransaction();
				tuiXachModel tuixach = session.get(tuiXachModel.class, tuiXachId);
				listKichThuoc.add(tuixach.getLoai_tui_xach());
				transaction.commit();
				session.close();
			}

		}

		return listKichThuoc;

	}
}
