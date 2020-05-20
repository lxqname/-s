package com.honor.week16;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * MCMXCIV
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 显示详情
 * 执行用时 :
 * 7 ms
 * , 在所有 Java 提交中击败了
 * 90.63%
 * 的用户
 * 内存消耗 :
 * 36.7 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 *
 * @Author: 白猛
 * @Date: 2019/9/29 13:30
 */
public class LeetCode_12_BM {


    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        char[] chs = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] ints = new int[]{1, 5, 10, 50, 100, 500, 1000};
        String roman = "";
        for (int i = ints.length - 1; i >= 0; i = i - 2) {
            int count = num / ints[i];
            String temp = "";
            if (count == 4) {
                temp += "" + chs[i] + chs[i + 1];
            } else if (count == 9) {
                temp += "" + chs[i] + chs[i + 2];
            } else {
                if (count >= 5) {
                    temp += "" + chs[i + 1];
                    count = count % 5;
                }
                for (int j = 0; j < count; j++) {
                    temp += "" + chs[i];
                }
            }
            num = num % ints[i];
            roman += temp;
        }
        return roman;
    }
}
