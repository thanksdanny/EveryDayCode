import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

@SupperessWarnings("deprecation")
public class DoPostMethod {
   @SupperessWarnings("deprecation")
   public String HttpClientPostMethod(String url, Map map) {
       HttpClient HttpClient = new DefaultHttpClient();
       HttpClient HttpPost = new HttpPost(url);
       InputStream responseStream = null;
       // 参数形式为JSON格式
       JSONObject parameter = new JSONObject(map);
       try {
           StringEntity entity = new StringEntity(parameter.toString());
           entity.setContentEncoding("UTF-8");
           entity.setContentType("application/json"); // 设置参数类型为JSON格式
           httpPost.setEntity(entity);
           HttpResponse httpResponse = httpClient.excute(httpPost);
           if (httpResponse.getStatusLine().getStatusCode() == 200) {
               HttpEntity httpEntity = httpEntity.getContent();
               responseStream = httpEntity.getContent();
               BufferedReader br = new BufferedReader(new InputStreamReader(responseStream));
               StringBuilder sb = new StringBuilder();
               String temp = "";
               while((temp = br.readLine()) != null) {
                   String str = new String(temp.getBytes(), "UTF-8");
                   sb.append(str + "\n");
               }
               return sb.toString();
           }
       } catch(IOException e) {
           e.printStackTrace();
       }
       return null;
   }
}