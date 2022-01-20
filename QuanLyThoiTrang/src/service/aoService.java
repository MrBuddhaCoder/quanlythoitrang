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

import model.aoModel;
import utils.ConnectionUtil;

public class aoService {

	protected static Session session = null;

	public static List<aoModel> getListAo() throws ClassNotFoundException, SQLException {
		List<aoModel> list = new ArrayList<>();
		Connection connection = ConnectionUtil.conDB();
		String query = "SELECT * FROM ao";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			aoModel ao = new aoModel(rs.getInt("id"), rs.getString("loai_ao"), rs.getString("color"),
					rs.getString("brand"));
			list.add(ao);
		}
		preparedStatement.close();
		connection.close();
		return list;
	}

	public static Session aoModelConfig() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(model.aoModel.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();

		return session;

	}

	public static void modifyAo(int id, String loai_ao, String color, String brand) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		aoModel ao = session.get(aoModel.class, id);
		ao.setLoai_ao(loai_ao);
		ao.setColor(color);
		ao.setBrand(brand);
		session.update(ao);
		transaction.commit();
		session.close();
	}

	public static void addAo(int id, String loai_ao, String color, String brand) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		aoModel ao = new aoModel(id, loai_ao, color, brand);
		session.save(ao);
		transaction.commit();
		session.close();

	}

	public static void delAo(int id) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		aoModel ao = session.get(aoModel.class, id);
		session.delete(ao);
		transaction.commit();
		session.close();

	}

}
