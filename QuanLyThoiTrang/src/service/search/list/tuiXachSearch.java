package service.search.list;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.tuiXachModel;
import service.tuiXachService;

public class tuiXachSearch extends tuiXachService {
	public static List<tuiXachModel> searchList(int id, String loai_tui_xach, String color, String brand) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(
				"from tuiXachModel where id =:id1 and loai_tui_xach =: loai_tui_xach1 and color =: color1 and brand =: brand1");
		query.setInteger("id1", id);
		query.setString("loai_tui_xach1", loai_tui_xach);
		query.setString("color1", color);
		query.setString("brand1", brand);

		List<tuiXachModel> tuiXachModelList = query.list();
		transaction.commit();
		session.close();
		return tuiXachModelList;
	}

	public static List<tuiXachModel> searchListById(int id) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from tuiXachModel where id =:id1 ");
		query.setInteger("id1", id);
		List<tuiXachModel> tuiXachModelList = query.list();
		transaction.commit();
		session.close();
		return tuiXachModelList;
	}

	public static List<tuiXachModel> searchListByType(String loai_tui_xach) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from tuiXachModel where  loai_tui_xach =: loai_tui_xach1 ");
		query.setString("loai_tui_xach1", loai_tui_xach);
		List<tuiXachModel> tuiXachModelList = query.list();
		transaction.commit();
		session.close();
		return tuiXachModelList;
	}

	public static List<tuiXachModel> searchListByColor(String color) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from tuiXachModel where  color =: color1 ");
		query.setString("color1", color);
		List<tuiXachModel> tuiXachModelList = query.list();
		transaction.commit();
		session.close();
		return tuiXachModelList;
	}

	public static List<tuiXachModel> searchListByBrand(String brand) {
		session = tuiXachService.tuiXachModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from tuiXachModel where  brand =: brand1");
		query.setString("brand1", brand);
		List<tuiXachModel> tuiXachModelList = query.list();
		transaction.commit();
		session.close();
		return tuiXachModelList;
	}
}
