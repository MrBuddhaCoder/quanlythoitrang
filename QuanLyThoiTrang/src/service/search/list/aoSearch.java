package service.search.list;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.aoModel;
import service.aoService;

//đưa ra danh sách các áo đã lọc
public class aoSearch extends aoService {
	// khi có đủ yếu tố
	public static List<aoModel> searchList(int id, String loai_ao, String color, String brand) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(
				"from aoModel where id =:id1 and loai_ao =: loai_ao1 and color =: color1 and brand =: brand1");
		query.setInteger("id1", id);
		query.setString("loai_ao1", loai_ao);
		query.setString("color1", color);
		query.setString("brand1", brand);
		List<aoModel> aoModelList = query.list();
		transaction.commit();
		session.close();
		return aoModelList;
	}

	public static List<aoModel> searchListByLoaiAo(String loai_ao) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from aoModel where loai_ao =: loai_ao1");
		query.setString("loai_ao1", loai_ao);
		List<aoModel> aoModelList = query.list();
		transaction.commit();
		session.close();
		return aoModelList;
	}

	public static List<aoModel> searchListByColor(String color) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from aoModel where color =: color1");
		query.setString("color1", color);
		List<aoModel> aoModelList = query.list();
		transaction.commit();
		session.close();
		return aoModelList;
	}

	public static List<aoModel> searchListByNhanHieu(String brand) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from aoModel where brand =: brand1");
		query.setString("brand1", brand);
		List<aoModel> aoModelList = query.list();
		transaction.commit();
		session.close();
		return aoModelList;
	}

	public static List<aoModel> searchListById(int id) {
		session = aoService.aoModelConfig();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from aoModel where id =:id1");
		query.setInteger("id1", id);
		List<aoModel> aoModelList = query.list();
		transaction.commit();
		session.close();
		return aoModelList;
	}
}
