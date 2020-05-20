package com.honor.week15;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week15
 * @Description:
 * @date: 2019/9/21 16:51
 */
public class LeetCode_17_LG {

    public static void main(String[] args){
        System.out.println(letterCombinations("134123"));
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 78.31%
     * 的用户
     * 内存消耗 :
     * 36.2 MB
     * , 在所有 Java 提交中击败了
     * 73.14%
     * 的用户
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character,List<Character>> map = new HashMap<Character,List<Character>>(){{
            put('2', Arrays.<Character>asList('a','b','c'));
            put('3', Arrays.<Character>asList('d','e','f'));
            put('4', Arrays.<Character>asList('g','h','i'));
            put('5', Arrays.<Character>asList('j','k','l'));
            put('6', Arrays.<Character>asList('m','n','o'));
            put('7', Arrays.<Character>asList('p','q','r','s'));
            put('8', Arrays.<Character>asList('t','u','v'));
            put('9', Arrays.<Character>asList('w','x','y','z'));
        }};

        if (digits.length() == 0){
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++){
            if (map.containsKey(digits.charAt(i))){
                result = addCharacter(result, map.get(digits.charAt(i)));
            }
        }

        return result;
    }

    private static  List<String> addCharacter(List<String> l, List<Character> characters) {
        List<String> result = new ArrayList<>();
        for (Character c: characters){
            for (String s: l){
                result.add(c+s);
            }
        }

        return result;
    }
}
