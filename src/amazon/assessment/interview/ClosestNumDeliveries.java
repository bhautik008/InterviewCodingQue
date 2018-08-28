package amazon.assessment.interview;

import java.util.*;
import java.util.Map.Entry;

public class ClosestNumDeliveries {

	public static void main(String[] args) {
		List<List<Integer>> location = new ArrayList<List<Integer>>();
		location.add(new ArrayList<Integer>(Arrays.asList(1,-3)));
		location.add(new ArrayList<Integer>(Arrays.asList(1,2)));
		location.add(new ArrayList<Integer>(Arrays.asList(2,4)));
		solution(3, location, 1);
	}
	
	public static void solution(int numDestination, List<List<Integer>> locations, int numDeliveries){
		List<Integer> loc = new ArrayList<Integer>();
		Map<List<Integer>, Double> distance = new HashMap<List<Integer>, Double>();
		for(int i=0;i<locations.size();i++) {
			int a = locations.get(i).get(0);
			int b = locations.get(i).get(1);
			double d = Math.sqrt(a*a + b*b);
			distance.put(locations.get(i), d);
		}
		SortedSet<Entry<List<Integer>, Double>> dist = sortedList(distance);
		for(Map.Entry<List<Integer>, Double> e1 : dist) {
			System.out.println("Key:"+e1.getValue().toString()+", V: "+e1.getValue());
		}
		//return loc;
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> sortedList(Map<K, V> map){
		SortedSet<Map.Entry<K, V>> sort = new TreeSet<Map.Entry<K,V>>(
					new Comparator<Map.Entry<K,V>>() {
						@Override
						public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
							int result = e1.getValue().compareTo(e2.getValue());
							return result != 0 ? result : 1;
						}
					}
				);
		sort.addAll((Collection<? extends Entry<K, V>>) map);
		return sort;
	}
}
