package com.zh.program;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.encrypt.AES;
import com.zh.program.Common.encrypt.BASE64;
import com.zh.program.Common.encrypt.RSA;
import com.zh.program.Common.utils.HTTP;
import com.zh.program.Common.utils.StrUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramApplicationTests {
    private static String webUrl = "http://localhost:8888/";
    private String get(String url,String params,String sign,String token){
        StringBuffer s = new StringBuffer();
        s.append(url)
                .append("?sign=").append(sign)
                .append("&params=").append(params);
        Map<String, String> map = null;
        if(!StrUtils.isBlank(token)){
            map = new HashMap<String, String>();
            map.put("token", token);
        }
        try {
            return HTTP.get(s.toString(), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private String post(String url,String params,String sign,String token, String key){
        Map<String, String> body = new HashMap<String, String>();
        Map<String, String> header = null;
        body.put("params", params);
        if(!StrUtils.isBlank(sign)){
            body.put("sign", sign);
        }
        if(!StrUtils.isBlank(key)){
            body.put("secret_key", key);
        }

        if(!StrUtils.isBlank(token)){
            header = new HashMap<String, String>();
            header.put("token", token);
        }

        try {
            return HTTP.postFrom(url, header, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Test
    public void contextLoads() throws Exception {
        String aesKey = "9d724a3f45fe9c99";
        String secretKey = RSA.encode(aesKey, RSA.getPublikKey(BASE64.decoderByte(Constants.RSA_PUBLIC_KEY)));
        String url = webUrl + "prize/draw";
        Map<String, Object> map = new HashMap<>();
        map.put("amount", 1);
        map.put("number", "2");
        map.put("type", 1);
        JSONObject json = new JSONObject(map);
        String params = AES.encrypt(json.toJSONString(), aesKey);
        String result = post(url, params, null, null, secretKey);
        System.out.println(result);
    }
    @Test
    public void insert() throws Exception {
        String id_card_num = "370883199409167412";
        String phone = "13165373280";
        String amount = "50";
        String invoice_code = "20";
        String invoice_id = "55";
        String code = "hcmb";
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 2;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("invoice_id", invoice_id + i);
            map.put("invoice_code", invoice_code + i);
            map.put("amount", amount + i);
            map.put("phone", phone);
            map.put("id_card_num", id_card_num);
            list.add(map);
        }
        String data = JSONArray.toJSONString(list);
        data = BASE64.encoder(data);
        data = URLEncoder.encode(data, "UTF-8");
        String url = webUrl + "invoice/insert?code=" + code + "&data=" + data;
        String result = HTTP.get(url, null);
        System.out.print(result);
    }

    @Test
    public void queryPrize(){
        String idCard = "13165373280";
        String url = webUrl + "prize/queryPrize?invoice_id=&phone=" + idCard;
        String result = null;
        try {
            result = HTTP.get(url, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(result);
    }

    @Test
    public void register() throws Exception{
        String aesKey = "5274e323bb474c36";
        String url = webUrl+"prize/draw";
        String secret_key = RSA.encode(aesKey, RSA.getPublikKey(BASE64.decoderByte(Constants.RSA_PUBLIC_KEY)));
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        map.put("type", "1");
        map.put("number", "1");
        map.put("amount", "3");

        JSONObject json = new JSONObject(map);
        String params = AES.encrypt(json.toJSONString(), aesKey);

        System.out.println(post(url, params, "", "", secret_key));
    }
    @Test
    public void login() throws Exception{
        String aesKey = "5274e323bb474c36";
        String url = webUrl+"login/admin";
        String secret_key = RSA.encode(aesKey, RSA.getPublikKey(BASE64.decoderByte(Constants.RSA_PUBLIC_KEY)));
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        map.put("account", "admin");
        map.put("password", "111111");
        JSONObject json = new JSONObject(map);
        String params = AES.encrypt(json.toJSONString(), aesKey);

        System.out.println(post(url, params, "", "", secret_key));
    }
}
