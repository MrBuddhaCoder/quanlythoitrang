package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class getFrequencyList {

	public static void main(String args[]) {
//		HashMap<Integer, String> map = new HashMap<>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(1);
		l1.add(4);
		l1.add(2);
		List<String> l2 = new ArrayList<String>();

//		for (Integer str : l1) {
//			map.put(str, "Ao");
//		}
//
//		for (Map.Entry<Integer, String> e : map.entrySet()) {
//			l2.add(e.getKey() + e.getValue());
//		}

		for (Integer l : l1) {
			l2.add(l.toString() + "Ao");
		}

		for (String str : l2)

			System.out.print(str + " ");

		Set<String> distinct = new HashSet<>(l2);
		System.out.println();
		for (String s : distinct) {
			System.out.println(s + ": " + Collections.frequency(l2, s));
		}

	}
}