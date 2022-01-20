package utils.sell;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.sell.sellAoModel;

//overriding
public class sellAoUtils extends sellUtils {

	public static void sell(String order_date, int ao_id) {
		// downcasting
		sellUtils sellutils = new sellAoUtils();
		sellAoUtils sell_ao_utils = (sellAoUtils) sellutils;

		session = sell_ao_utils.sellModelConfig();
		Transaction transaction = session.beginTransaction();
		sellAoModel sell = new sellAoModel(order_date, ao_id);
		session.save(sell);
		transaction.commit();
		session.close();
	}

	@Override
	public Session sellModelConfig() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(model.sell.sellAoModel.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();

		return session;
	}

}
