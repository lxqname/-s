package com.honor.week4;

/**
 * 
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * ABCDEF
 *
 * A C E
 * B D F
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week4
 * @Description:
 * @date: 2019/6/30 13:09
 */
public class LeetCode_06_LG {
    
    public static void main(String[] args){  
        String s = "ABCDEF";
        int numRows = 2;
        System.out.println(convert(s, numRows));
    }


    /**
     * 执行用时 :25 ms, 在所有 Java 提交中击败了57.74%的用户
     * 内存消耗 :44.8 MB, 在所有 Java 提交中击败了70.46%的用户
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0 ; i < sb.length; i++){
            sb[i] = new StringBuffer();
        }

        int tag = 0;
        int index = -1;

        for (int i = 0; i < s.length() ;i ++){

            if (tag >= numRows || tag == 0){
                index *= -1;
            }
            if (tag >= numRows){
                tag = numRows - 2;
            }
            sb[tag].append(s.charAt(i));


            tag += index;
            if(tag < 0){
                tag = 1;
            }
        }

        for (int i = 1 ; i < sb.length; i++){
            sb[0].append(sb[i]);
        }


        return sb[0].toString();
    }
}
