package com.vsp.string;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vawani.pati
 *
 */
public class FindRepeatedChar {
	public static void main(String[] args) {
		repeatedChar("Programming");
		repeatedChar("Combination");
		repeatedChar("Java");
	}

	public static void repeatedChar(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		Instant i = Instant.now();
		char c[] = str.toCharArray();
		for (char temp : c) {
			if (map.get(temp) != null) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		// One more loop extra to get list which takes more time then the previous one
//		List<Character> li=str.chars().mapToObj(X -> (char) X).collect(Collectors.toList());
//		li.forEach(M->{
//			if (map.get(M) != null) {
//				map.put(M, map.get(M) + 1);
//			}else {
//				map.put(M, 1);
//			}
//		});

		map.entrySet().forEach((entry -> {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}));
		System.out.println(Duration.between(i, Instant.now()));
	}

}
