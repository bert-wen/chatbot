package com.sveinn.chatbotinterfaces;

import cn.hutool.core.util.HexUtil;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.junit.jupiter.api.Test;


import java.io.IOException;

class ApiTests {

    @Test
    public void queryUnansweredQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        httpGet.addHeader("cookie","zsxq_access_token=D73721E4-275E-68FE-F501-40FFCD834E2F_A5ADCCA22E845F72; abtest_env=product; zsxqsessionid=5eefd84a2758c65020865ba6a9d07b6c; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22118845181844812%22%2C%22first_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhMTE2NmViYTM0MDUtMDIxZjQwZjczODg5YTg0LTdjNTQ2NDdlLTEzMjcxMDQtMThhMTE2NmViYTQzMjIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxMTg4NDUxODE4NDQ4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22118845181844812%22%7D%2C%22%24device_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%7D");
        httpGet.addHeader("Content-Type","application/json;charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/411858824454158/comments");
        httpPost.addHeader("cookie","zsxq_access_token=D73721E4-275E-68FE-F501-40FFCD834E2F_A5ADCCA22E845F72; abtest_env=product; zsxqsessionid=5eefd84a2758c65020865ba6a9d07b6c; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22118845181844812%22%2C%22first_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhMTE2NmViYTM0MDUtMDIxZjQwZjczODg5YTg0LTdjNTQ2NDdlLTEzMjcxMDQtMThhMTE2NmViYTQzMjIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxMTg4NDUxODE4NDQ4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22118845181844812%22%7D%2C%22%24device_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%7D");
        httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
        String jsonParam="{\"req_data\":{\"text\":\"你好呀\\n\",\"image_ids\":[],\"replied_comment_id\":588581211428124,\"mentioned_user_ids\":[]}}";
        StringEntity stringEntity = new StringEntity(jsonParam, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void hexadecimalToText(){
        System.out.println("\u4e3a\u4ec0\u4e48\u6ca1\u6709\u5de7\u514b\u529b");
    }

}
