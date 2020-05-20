package com.honor.liuxinquan.day1030;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义map转json及json转map(字符串)
 */
public class Test7 {
    /**
     * json转map
     * @param jsonStr
     * @return
     */
    public static Map<String,String> getMapByJsonStr(String jsonStr){
        final Map<String,String>map;
        if (StringUtils.isEmpty(jsonStr)){
            return new HashMap<>();
        }
        final JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        map=new HashMap<>(jsonObject.keySet().size());
        jsonObject.keySet().stream().forEach(t->{
            map.put(t,jsonObject.getString(t));
        });
        return map;
    }

    /**
     * json转map
     * @param map
     * @return
     */
    public static String getJsonByMap(Map<String,String>map){
        if (ObjectUtil.isNull(map)){
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String,String> m:map.entrySet()) {
            jsonObject.put(m.getKey(),m.getValue());
        }
        return jsonObject.toJSONString();
    }
}
