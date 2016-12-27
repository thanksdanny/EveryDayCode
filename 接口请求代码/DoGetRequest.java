import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class DoGetRequest {
    /*
     * get请求方式
     * @author:me
     */
     public static String httpGetMethod(String url, Map<Object, Object> map, ) throws InstantiationException, IllegalAccessException {
         HttpClient HttpClient = new DefaultHttpClient();
         Object value;
         Object urlInfo = "";
         for(Object key:map.keySet()){
             value = map.get(key);
             urlInfo += key + "=" + value + "&";
         }
         urlInfo = urlInfo.toString().substring(0, urlInfo.toString().length()-1);
         url = url + "?" + urlInfo.toString();
         HttpGet httpGet = new HttpGet(url);
         HttpResponse httpResponse = null;
         try {
             httpResponse = HttpClient.excute(httpGet);
             StringBuilder sb = new StringBuilder();
             InputStream inputStrem = httpResponse.getEntity().getContent();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStrem, "UTF-8"));
             String temp = "";
             while((temp = br.readLine()) != null) {
                 sb.append(tmp + "\n");
             }
             return sb.toString();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
}