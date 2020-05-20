package com.honor.liuxinquan.day1109;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author 86151
 */
public class RelativeUtil {
    private static final Logger logger = LoggerFactory.getLogger(RelativeUtil.class);
    /**
     * 获取比例
     * @param divisor 除数
     * @param dividend 被除数
     * @return
     */
    public static double relative(Integer divisor, Integer dividend){
        if(divisor == 0 || dividend == 0){
            return 0D;
        }
        Double consequence = (new Double(dividend) / new Double(divisor)) * 100 - 100;
        consequence = Double.parseDouble(String.format("%.2f", consequence));
        return consequence;
    }

    /**
     * 获取百分比
     * @param divisor 除数
     * @param dividend 被除数
     * @return
     */
    public static double percent(Integer divisor, Integer dividend){
        if(divisor == 0 || dividend == 0){
            return 0D;
        }
        Double consequence = (new Double(dividend) / new Double(divisor)) * 100;
        consequence = Double.parseDouble(String.format("%.2f", consequence));
        return consequence;
    }

    public static BigDecimal relative(BigDecimal divisor, BigDecimal dividend){


        logger.info("divisor:"+divisor+"  dividend:"+dividend);
        if (dividend.compareTo(BigDecimal.ZERO) == 0 && divisor.compareTo(BigDecimal.ZERO) == 0 ){
            return new BigDecimal(0);
        } else if (divisor.compareTo(BigDecimal.ZERO) == 0 ){
            return new BigDecimal(100);
        }
        try {
            BigDecimal divide = dividend.divide(divisor, 4,     BigDecimal.ROUND_HALF_UP);
            BigDecimal multiply = divide.multiply(new BigDecimal(100));

            return        multiply.subtract(new BigDecimal(100));
        } catch (Exception e) {
            e.printStackTrace();
            return new BigDecimal(0);
        }
    }

}
