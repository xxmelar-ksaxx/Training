// Yousif Al-Dhfeery

package Lesson_2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class p_2_9_Map {

	public static void main(String[] args) {
		
		// Hash map
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1,"Yousif");
		hm.put(2, "Melar");
		System.out.println("Hash Map:");
		
		for(Map.Entry m : hm.entrySet()) {
			System.out.println("ID= "+m.getKey()+"  Name= "+m.getValue());
		}
		
		
		// Hash Table
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		
		ht.put(3, "Ahmed");
		ht.put(4,"Bateh");
		System.out.println("\nHash Table");
		
		for(Map.Entry m: ht.entrySet()) {
			System.out.println("ID= "+m.getKey()+"   Name= "+m.getValue());
		}
		
		
		// Tree Map
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		
		tm.put(5,"Sloom");
		tm.put(6, "Ali");
		System.out.println("\nTree Map");
		
		for(Map.Entry m: tm.entrySet()) {
			System.out.println("ID= "+m.getKey()+"   Name= "+m.getValue());
		}
		
	}
	
}
