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

import model.quanModel;
import utils.ConnectionUtil;

public class quanService {

	protected static Session session = null;

	public static List<quanModel> getListQuan() throws ClassNotFoundException, SQLException {
		List<quanModel> list = new ArrayList<>();
		Connection connection = ConnectionUtil.conDB();
		String query = "SELECT * FROM quan";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			quanModel quan = new quanModel(rs.getInt("id"), rs.getString("loai_quan"), rs.getString("color"),
					rs.getString("brand"));
			list.add(quan);
		}
		preparedStatement.close();
		connection.close();
		return list;
	}

	public static Session quanModelConfig() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(model.quanModel.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();

		return session;

	}

	public static void addQuan(int id, String loai_quan, String color, String brand) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		quanModel quan = new quanModel(id, loai_quan, color, brand);
		session.save(quan);
		transaction.commit();
		session.close();

	}

	public static void modifyQuan(int id, String loai_quan, String color, String brand) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		quanModel quan = session.get(quanModel.class, id);
		quan.setLoai_quan(loai_quan);
		quan.setColor(color);
		quan.setBrand(brand);
		session.update(quan);
		transaction.commit();
		session.close();
	}

	public static void delQuan(int id) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		quanModel quan = session.get(quanModel.class, id);
		session.delete(quan);
		transaction.commit();
		session.close();

	}

}
