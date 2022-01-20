package service.thongke;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

import model.sell.orderHistoryModel;
import service.datHangService;

public class thongKeService {

	public static List<Integer> listAo = new ArrayList<>();
	public static List<Integer> listQuan = new ArrayList<>();
	public static List<Integer> listTuiXach = new ArrayList<>();

	public static void getList(String startDate1, String endDate1)
			throws ClassNotFoundException, SQLException, ParseException {
		// A Multimap that can hold duplicate key-value pairs
		ListMultimap<Date, String> orderMap = ArrayListMultimap.create();
		// biến đếm
		int aoCount = 0;
		int quanCount = 0;
		int tuiXachCount = 0;

		// record order trong database
		List<orderHistoryModel> list;
		list = datHangService.getListDatHang();

		for (orderHistoryModel order1 : list) {
			// nếu tồn tại id trong record 1/3 put vào orderMap

			if (order1.getAo_id() != 0) {
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(order1.getOrder_date());
				orderMap.put(date1, getListAo().get(aoCount));
				aoCount++;
			}
			if (order1.getQuan_id() != 0) {
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(order1.getOrder_date());
				orderMap.put(date1, getListQuan().get(quanCount));
				quanCount++;
			}
			if (order1.getTui_xach_id() != 0) {
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(order1.getOrder_date());
				orderMap.put(date1, getListTuiXach().get(tuiXachCount));
				tuiXachCount++;
			}
		}

		// cài lại sao cho thời gian nhập vào là người dùng nhập
		// "1/12/2021"
		// "14/12/2021"
		Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDate1);
		Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDate1);

		// danh sách để lọc giá trị trong khoảng thời gian từ orderMap
		List<String> listMultimapFilter = new ArrayList<String>(
				Multimaps.filterKeys(orderMap, s -> isWithinRange(s, startDate, endDate)).values());
		System.out.println(listMultimapFilter);

		// 4 sản phẩm chạy nhất
		List<String> listMostFre = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			if (listMultimapFilter.isEmpty()) {
				break;
			}
			listMostFre.add(mostCommon(listMultimapFilter));
			listMultimapFilter.removeIf(s -> s.equals(mostCommon(listMultimapFilter)));

		}
		System.out.println(listMostFre);

		listAo = addListAo(listMostFre);
		listQuan = addListQuan(listMostFre);
		listTuiXach = addListTuiXach(listMostFre);
	}

	public static List<Integer> addListTuiXach(List<String> list) {
		List<Integer> listTuiXach = new ArrayList<>();
		for (String str : list) {
			if (str.contains("tuixach"))
				listTuiXach.add(Integer.parseInt(str.replaceAll("[^0-9]", "")));
		}
		return listTuiXach;
	}

	public static List<Integer> addListQuan(List<String> list) {
		List<Integer> listQuan = new ArrayList<>();
		for (String str : list) {
			if (str.contains("quan"))
				listQuan.add(Integer.parseInt(str.replaceAll("[^0-9]", "")));
		}
		return listQuan;
	}

	public static List<Integer> addListAo(List<String> list) {
		List<Integer> listAo = new ArrayList<>();
		for (String str : list) {
			if (str.contains("ao"))
				listAo.add(Integer.parseInt(str.replaceAll("[^0-9]", "")));
		}
		return listAo;
	}
//
	public static String mostCommon(List<String> list) {
		Map<String, Integer> map = new HashMap<>();

		for (String t : list) {
			Integer val = map.get(t);
			map.put(t, val == null ? 1 : val + 1);
		}

		Entry<String, Integer> max = null;

		for (Entry<String, Integer> e : map.entrySet()) {
			if (max == null || e.getValue() > max.getValue())
				max = e;
		}

		return max.getKey();
	}

	public static List<String> getListAo() throws ClassNotFoundException, SQLException {
		List<orderHistoryModel> list;
		list = datHangService.getListDatHang();
		List<String> aoid = new ArrayList<>();
		for (orderHistoryModel list1 : list) {
			if (list1.getAo_id() != 0)
				aoid.add(list1.getAo_id() + "ao");
		}
		return aoid;
	}

	public static List<String> getListQuan() throws ClassNotFoundException, SQLException {
		List<orderHistoryModel> list;
		list = datHangService.getListDatHang();
		List<String> quanid = new ArrayList<>();
		for (orderHistoryModel list1 : list) {
			if (list1.getQuan_id() != 0)
				quanid.add(list1.getQuan_id() + "quan");
		}
		return quanid;
	}

	public static List<String> getListTuiXach() throws ClassNotFoundException, SQLException {
		List<orderHistoryModel> list;
		list = datHangService.getListDatHang();
		List<String> tuixachid = new ArrayList<>();
		for (orderHistoryModel list1 : list) {
			if (list1.getTui_xach_id() != 0)
				tuixachid.add(list1.getTui_xach_id() + "tuixach");
		}
		return tuixachid;
	}

	public static boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
		return testDate.after(startDate) && testDate.before(endDate);
	}
}
