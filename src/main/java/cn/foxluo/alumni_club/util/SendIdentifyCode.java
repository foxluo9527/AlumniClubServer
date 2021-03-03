package cn.foxluo.alumni_club.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendIdentifyCode {
	private static final String ENCODING = "UTF-8";
	/**
	 * @param mobile 手机号码
	 * @param code   验证码
	 * @param model  0:注册验证;1:登录验证
	 * @return 验证信息，为null则发送验证失败
	 */
	public static JSONObject sendIdentifyCode(String mobile,String code,int model,Constant Constant) {
		JSONObject result;
		String resultText;
		String postStr;
        postStr = Constant.SEND_URL;
        Map < String, String > params = new HashMap <> ();
		params.put("apikey", Constant.API_KEY);
		String content=null;
		if (model==Constant.MODEL_REGISTER) {
			content=Constant.TEXT_IDENTIFY.replace("#code#", code);
		}else if (model==Constant.MODEL_LOGIN) {
			content=Constant.TEXT_LOGIN.replace("#code#", code);
		}else if (model==Constant.MODEL_CHANGE_PASS) {
			content=Constant.TEXT_CHANGE_PASS.replace("#code#", code);
		}
		params.put("text", content);
		params.put("mobile",mobile);
		resultText=post(postStr, params);
		result=(JSONObject) JSONObject.parse(resultText);
		System.out.println(resultText);
		return result;
	}
	/**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map < String, String > paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List < NameValuePair > paramList = new ArrayList <> ();
                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                        param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList,
                    ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert response != null;
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}
