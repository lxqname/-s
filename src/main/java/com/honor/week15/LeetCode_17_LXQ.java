package com.honor.week15;

import java.util.LinkedList;

/**
 * @author 86151
 */
public class LeetCode_17_LXQ {
    public static void main(String[] args) {
        String a="234";
        LinkedList<String> strings = new LinkedList<>();
        String[] map={"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        strings.add("");
        for (int i=0;i<a.length();i++){
            char c = a.charAt(i);
            int numericValue = Character.getNumericValue(c);
            System.out.println(numericValue);
            while (strings.peek().length()==i){
                String remove = strings.remove();
                for (char item : map[numericValue].toCharArray()) {
                    strings.add(remove+item);
                }
            }
        }
        System.out.println(strings);
    }
}
