package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.tuiXachModel;
import utils.ConnectionUtil;

public class tuiXachService {

	protected static Session session = null;

	public static List<tuiXachModel> getListTuiXach() throws ClassNotFoundException, SQLException {
		List<tuiXachModel> list = new ArrayList<>();
		Connection connection = ConnectionUtil.conDB();
		String query = "SELECT * FROM tui_xach";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			tuiXachModel tuixach = new tuiXachModel(rs.getInt("id"), rs.getString("loai_tui_xach"),
					rs.getString("color"), rs.getString("brand"));
			list.add(tuixach);
		}
		preparedStatement.close();
		connection.close();
		return list;
	}

	public static Session tuiXachModelConfig() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(model.tuiXachModel.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();

		return session;

	}

	public static void modifyTuiXach(int id, String loai_tui_xach, String color, String brand) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		tuiXachModel tuixach = session.get(tuiXachModel.class, id);
		tuixach.setLoai_tui_xach(loai_tui_xach);
		tuixach.setColor(color);
		tuixach.setBrand(brand);
		session.update(tuixach);
		transaction.commit();
		session.close();
	}

	public static void addTuiXach(int id, String loai_tui_xach, String color, String brand) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		tuiXachModel tuixach = new tuiXachModel(id, loai_tui_xach, color, brand);
		session.save(tuixach);
		transaction.commit();
		session.close();

	}

	public static void delTuiXach(int id) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		tuiXachModel tuixach = session.get(tuiXachModel.class, id);
		session.delete(tuixach);
		transaction.commit();
		session.close();

	}
}
