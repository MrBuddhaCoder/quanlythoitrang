package utils.sell;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.sell.sellQuanModel;

public class sellQuanUtils extends sellUtils {

	public static void sell(String order_date, int quan_id) {
		// upcasting
		sellUtils sell_utils = new sellQuanUtils();

		session = sell_utils.sellModelConfig();
		Transaction transaction = session.beginTransaction();
		sellQuanModel sell = new sellQuanModel(order_date, quan_id);
		session.save(sell);
		transaction.commit();
		session.close();
	}

	// vì overriding nên truy cập được phần con
	@Override
	public Session sellModelConfig() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(model.sell.sellQuanModel.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();

		return session;
	}

}
