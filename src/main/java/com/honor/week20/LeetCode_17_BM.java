package com.honor.week20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: 白猛
 * @Date: 2019/9/30 17:40
 */
public class LeetCode_17_BM {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

    private static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits != null) {
            backtrack("", digits);
        }
        return result;
    }

    private static void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            result.add(combination);
        } else {
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backtrack(combination + letters.charAt(i), digits.substring(1));
            }
        }
    }

}
