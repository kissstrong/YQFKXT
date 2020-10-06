package com.yqfk.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-29 10:42
 */
public class GetAddr {
    /**
     * txt|jsonp|xml
     */
    //public static String DATATYPE = "text";//返回文本格式
    public static String DATATYPE = "jsonp";//返回json格式
    public static String get(String urlString, String token) throws Exception {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(5 * 1000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("token", token);
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                StringBuilder builder = new StringBuilder();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                for (String s = br.readLine(); s != null; s = br.readLine()) {
                    builder.append(s);
                }
                br.close();
                return builder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String queryIP(String ip) throws Exception {
        //String url = "https://api.ip138.com/ipv4/?ip=" + ip + "&datatype=" + DATATYPE;
        /*https://api.ip138.com/ipv4/?ip=58.16.180.3&datatype=jsonp&callback=find&token=cc87f3c77747bccbaaee35006da1ebb65e0bad57*/
        String url = "https://api.ip138.com/ipv4/?ip=" + ip + "&datatype=" + DATATYPE+"&callback=find";
        String token = "52195ede981ac9fc96e8165387921b12";
        return get(url, token);
    }

    public static Map<String, String> getLocalProvinceAndCity(String ip)throws Exception {
        String s = queryIP(ip);
        System.out.println(s);
        String substring = s.substring(5,s.length()-1);
        JSONObject jsonObject=new JSONObject(substring);
        JSONArray data = jsonObject.getJSONArray("data");
        Map<String, String> map=new HashMap<String, String>();
        if (!data.get(1).equals("")){
            map.put("province",data.get(1).toString());
            map.put("city",data.get(2).toString());
            return map;
        }else {
            return map;
        }
    }
    public static void main(String[] args) throws Exception {
        //String s = "117.25.13.123";
        String s = "127.0.0.1";
        Map<String, String> localProvinceAndCity = getLocalProvinceAndCity(s);
        if (localProvinceAndCity.get("province")==null){
            System.out.println("当地地址");
        }else {
            System.out.println(localProvinceAndCity.get("province"));
            System.out.println(localProvinceAndCity.get("city"));
        }
    }
}



//以下是使用示例：

//QueryHelper.queryIP("8.8.8.8");}
