package sample;

import java.sql.Connection;
import java.sql.SQLException;

import service.datHangService;

public class projectTest {
	static Connection conn = null;

	public static void main(String[] args) throws SQLException {
		datHangService.getListDatHangTheoThang("8/12/2021");
	}
}
