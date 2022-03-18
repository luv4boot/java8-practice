package org.java.practice;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(isUniqueChars("Mdhav"));

//        System.out.println(isRotation("MadhavPonnana2", "Ponnana2Madhav"));

//        findDuplicateCharacters("Madhava Ponnana");
        System.out.println(findFirstNonRepeatedCharacter("madhav"));
    }

    private static boolean isUniqueChars(String word) {
        HashSet<Character> set = new HashSet();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRotation(String str, String rotation) {
        String word = str + str;
        if (word.contains(rotation)) {
            return true;
        }
        return false;
    }

    private static void findDuplicateCharacters(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length()-1; i++) {
            char c = word.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    private static Character findFirstNonRepeatedCharacter(String word) {
        Map<Character, Integer> countCharacters = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < word.length() - 1; i++) {
            Character c = word.charAt(i);
            if (!countCharacters.containsKey(c)) {
                countCharacters.put(c, 1);
            } else {
                countCharacters.put(c, countCharacters.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> e : countCharacters.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return null;

    }


}