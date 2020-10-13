package com.yqfk.utils;

import com.yqfk.pojo.City;
import com.yqfk.pojo.Province;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * @author cyz
 * @date 2020-09-28 19:57
 */
public class MapProvince {
    public static Map<String, Province> getProvince() throws Exception {
        String request = GetJson.getRequest();
        JSONObject jsonObject=new JSONObject(request);
        JSONArray newslist = jsonObject.getJSONArray("newslist");
        Map<String,Province> map=new HashMap<String, Province>();
        for (int i = 0; i < newslist.length(); i++) {
            JSONObject o = (JSONObject) newslist.get(i);
            JSONArray cities = o.getJSONArray("cities");
            Map<String, City> cityMap=new HashMap<String, City>();
                for (int j = 0; j < cities.length(); j++) {
                    JSONObject jsonObject1= (JSONObject) cities.get(j);
                    Integer currentConfirmedCount = (Integer) jsonObject1.get("currentConfirmedCount");
                    Integer confirmedCount = (Integer) jsonObject1.get("confirmedCount");
                    Integer curedCount = (Integer) jsonObject1.get("curedCount");
                    Integer deadCount = (Integer) jsonObject1.get("deadCount");
                    Integer suspectedCount = (Integer) jsonObject1.get("suspectedCount");
                    String cityName = (String) jsonObject1.get("cityName");
                    cityMap.put(cityName,new City(currentConfirmedCount,confirmedCount,curedCount,deadCount,suspectedCount,cityName));
                }
            String provinceName = o.get("provinceName").toString();
            Integer currentConfirmedCount = (Integer) o.get("currentConfirmedCount");
            Integer confirmedCount = (Integer) o.get("confirmedCount");
            Integer curedCount = (Integer) o.get("curedCount");
            Integer deadCount = (Integer) o.get("deadCount");
            Integer suspectedCount = (Integer) o.get("suspectedCount");
            Province province = new Province(currentConfirmedCount, confirmedCount, curedCount, deadCount, suspectedCount, provinceName,cityMap);
            map.put(provinceName,province);
        }
        return map;
    }
}
