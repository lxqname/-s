package com.honor.week5;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * @author 傅国俊
 * @since 2019年07月22日 10:54
 */
public class LeetCode_06_FGJ {

    public static void main(String[] args) {
        String s1 = "LEETCODEISHIRING";
        String convertS13 = "LCIRETOESIIGEDHN";
        System.out.println(convert(s1, 3).equals(convertS13));
        String convertS14 = "LDREOEIIECIHNTSG";
        System.out.println(convert(s1, 4).equals(convertS14));
    }

    /**
     * Z 字形变换
     * 执行用时 : 21 ms , 在所有 Java 提交中击败了 61.85% 的用户
     * 内存消耗 : 44.8 MB , 在所有 Java 提交中击败了 70.46% 的用户
     *
     * @param s       字符串
     * @param numRows 行数
     * @return String Z 字形变换后的字符串
     */
    public static String convert(String s, int numRows) {
        if (1 == numRows) {
            // 不用变换，输出即为原字符串
            return s;
        }
        StringBuilder[] list = new StringBuilder[numRows];
        int index = 0;
        boolean downDirection = true;
        for (char c : s.toCharArray()) {
            StringBuilder stringBuilder = list[index];
            if (null == stringBuilder) {
                stringBuilder = new StringBuilder();
                list[index] = stringBuilder;
            }
            stringBuilder.append(c);
            if (downDirection) {
                if (index + 1 == numRows) {
                    downDirection = false;
                    index--;
                } else {
                    index++;
                }
            } else {
                if (index == 0) {
                    downDirection = true;
                    index++;
                } else {
                    index--;
                }
            }
        }
        StringBuilder response = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            if (null != stringBuilder) {
                response.append(stringBuilder);
            }
        }
        return response.toString();
    }

    /**
     * 官方题解（强大在于直接算出每一行index规律，自己算不出，虽然感觉能找规律）
     *
     * @param s       字符串
     * @param numRows 行数
     * @return String Z 字形变换后的字符串
     */
    public String convertFromOfficialSolution(String s, int numRows) {
        if (1 == numRows) {
            // 不用变换，输出即为原字符串
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }
}
