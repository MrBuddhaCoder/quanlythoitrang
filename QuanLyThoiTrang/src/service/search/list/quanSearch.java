package service.search.list;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.quanModel;
import service.quanService;

public class quanSearch extends quanService {
	public static List<quanModel> searchList(int id, String loai_quan, String color, String brand) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(
				"from quanModel where id =:id1 and loai_quan =: loai_quan1 and color =: color1 and brand =: brand1");
		query.setInteger("id1", id);
		query.setString("loai_quan1", loai_quan);
		query.setString("color1", color);
		query.setString("brand1", brand);

		List<quanModel> quanModelList = query.list();
		transaction.commit();
		session.close();
		return quanModelList;
	}

	public static List<quanModel> searchListById(int id) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from quanModel where id =:id1");
		query.setInteger("id1", id);
		List<quanModel> quanModelList = query.list();
		transaction.commit();
		session.close();
		return quanModelList;
	}

	public static List<quanModel> searchListByLoaiQuan(String loai_quan) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from quanModel where  loai_quan =: loai_quan1 ");
		query.setString("loai_quan1", loai_quan);
		List<quanModel> quanModelList = query.list();
		transaction.commit();
		session.close();
		return quanModelList;
	}

	public static List<quanModel> searchListByColor(String color) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from quanModel where  color =: color1 ");
		query.setString("color1", color);
		List<quanModel> quanModelList = query.list();
		transaction.commit();
		session.close();
		return quanModelList;
	}

	public static List<quanModel> searchListByBrand(String brand) {
		session = quanService.quanModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from quanModel where brand =: brand1");
		query.setString("brand1", brand);
		List<quanModel> quanModelList = query.list();
		transaction.commit();
		session.close();
		return quanModelList;
	}
}
