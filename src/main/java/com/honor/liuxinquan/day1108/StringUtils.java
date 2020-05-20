package com.honor.liuxinquan.day1108;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    private static String nullStringLow = "null";
    private static String nullStringTop = "NULL";
    private static String nullStringThree = "Null";

    public static boolean isNull(String param)
    {
        try
        {
            if (param == null || "".equals(param.trim()) || param.length() <= 0 || nullStringLow.equals(param) || nullStringTop.equals(param) || nullStringThree.equals(param)) {
                return true;
            }

        } catch (Exception e)
        {

        }

        return false;

    }

    public static List<Entry<String,Integer>> sortMap(Map<String,Integer> map)
    {
        Set<Entry<String,Integer>> set=map.entrySet();

        List<Entry<String,Integer>> list=new ArrayList<>(set);

        Collections.sort(list,new Comparator<Entry<String,Integer>>()
        {

            @Override
            public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1)
            {
                if(arg1.getValue()-arg0.getValue()>0) {
                    return 1;
                } else if(arg1.getValue()-arg0.getValue()==0) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });


        return list;
    }

    public static String getTime()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private static String TOTAL_PATTERN = ".*total\":(?<total>\\d+).*";

    public static int getCount(String html) {
        int count = 0;
        try {
            Pattern p = Pattern.compile(TOTAL_PATTERN);
            Matcher m = p.matcher(html);
            if (m.matches()) {
                String value = m.group("total");
                count = Integer.parseInt(value);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /********
     * 替换表情
     *
     * @param source
     * @param slipStr
     * @return
     */
    public static String filterEmoji(String source, String slipStr)
    {
        if (isNull(source)) {
            return source;
        }

        return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
    }


    private static int eight = 8;
    private static String one = "1";

    /******************
     * 获取天数
     * @param starttime
     * @param endtime
     * @param fgap
     * @return
     * @throws ParseException
     */
    public static Map<String,Integer> getDate(String starttime,String endtime,String fgap) throws ParseException
    {
        Map<String,Integer> dateMap=new TreeMap<>();
        Calendar calendar=Calendar.getInstance();
        long difference=0;
        int field=0;
        String format=getFormat(starttime.length());
        SimpleDateFormat dateFormat=new SimpleDateFormat(format);
        long end=dateFormat.parse(endtime).getTime();
        long start=dateFormat.parse(starttime).getTime();
        if(format.length()==eight) {
            end=end+1000*60*60*23;
        }
        SimpleDateFormat simpleDateFormat;
        calendar.setTime(new Date(end));
        if(one.equals(fgap))
        {
            field=Calendar.HOUR_OF_DAY;
            difference=(end-start)/(1000*60*60)+1;
            simpleDateFormat=new SimpleDateFormat("yyyyMMddHH");
        }else
        {
            field=Calendar.DAY_OF_MONTH;
            difference=(end-start)/(1000*60*60*24)+1;
            simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        }

        for (int i = 0; i <difference; i++)
        {
            String date=simpleDateFormat.format(calendar.getTime());
            System.out.println(date);
            dateMap.put(String.valueOf(simpleDateFormat.parse(date).getTime()),0);
            calendar.add(field,-1);
        }

        return dateMap;
    }

    public static String getFormat(int length)
    {
        String format="";
        switch(length)
        {
            case 10:
                format="yyyyMMddHH";
                break;
            case 12:
                format="yyyyMMddHHmm";
                break;
            case 14:
                format="yyyyMMddHHmmss";
                break;

            default :
                format="yyyyMMdd";
                break;
        }

        return format;
    }

    private static String BLANK_STRING = "\\s*|\t|\r|\n";

    public static String replaceBlank(String str) {
        if (str != null) {
            Pattern p = Pattern.compile(BLANK_STRING);
            Matcher m = p.matcher(str);
            str = m.replaceAll("");
        }
        return str;
    }
}
