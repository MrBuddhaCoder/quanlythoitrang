package utils.sell;

import org.hibernate.Session;

public abstract class sellUtils {
	protected static Session session = null;

	public abstract Session sellModelConfig();
}
