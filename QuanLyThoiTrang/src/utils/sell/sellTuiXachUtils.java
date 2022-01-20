package utils.sell;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.sell.sellTuiXachModel;

public class sellTuiXachUtils extends sellUtils {

	public static void sell(String order_date, int tui_xach_id) {
		sellUtils sell_utils = new sellUtils() {

			@Override
			public Session sellModelConfig() {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(model.sell.sellTuiXachModel.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				SessionFactory factory = configuration.buildSessionFactory(builder.build());

				Session session = factory.openSession();

				return session;
			}

		};
		session = sell_utils.sellModelConfig();
		Transaction transaction = session.beginTransaction();
		sellTuiXachModel sell = new sellTuiXachModel(order_date, tui_xach_id);
		session.save(sell);
		transaction.commit();
		session.close();
	}

	@Override
	public Session sellModelConfig() {
		// TODO Auto-generated method stub
		return null;
	}

}
