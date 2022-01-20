package sample;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringToDate {

	public static void main(String args[]) throws ParseException {

		Map<Date, Integer> m = new HashMap<Date, Integer>();

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		m.put(new java.sql.Date(dateFormat.parse("31-05-2011").getTime()), 67);
		m.put(new java.sql.Date(dateFormat.parse("01-06-2011").getTime()), 89);
		m.put(new java.sql.Date(dateFormat.parse("10-06-2011").getTime()), 56);
		m.put(new java.sql.Date(dateFormat.parse("25-05-2011").getTime()), 34);

		Map<Date, Integer> m1 = new TreeMap(m);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		for (Map.Entry<Date, Integer> entry : m1.entrySet()) {
			System.out.println(df.format(entry.getKey()));
		}

	}
}