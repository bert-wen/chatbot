package com.sveinn;

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
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/51112481428254/topics?scope=unanswered_questions&count=20");
        httpGet.addHeader("cookie","abtest_env=product; zsxqsessionid=5eefd84a2758c65020865ba6a9d07b6c; sajssdk_2015_cross_new_user=1; zsxq_access_token=E475EF50-8D46-3866-A186-4B3DDE554F77_A5ADCCA22E845F72; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22118845181844812%22%2C%22first_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhMTE2NmViYTM0MDUtMDIxZjQwZjczODg5YTg0LTdjNTQ2NDdlLTEzMjcxMDQtMThhMTE2NmViYTQzMjIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxMTg4NDUxODE4NDQ4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22118845181844812%22%7D%2C%22%24device_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%7D");
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
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/211828211824121/answer");
        httpPost.addHeader("cookie","abtest_env=product; zsxqsessionid=5eefd84a2758c65020865ba6a9d07b6c; sajssdk_2015_cross_new_user=1; zsxq_access_token=E475EF50-8D46-3866-A186-4B3DDE554F77_A5ADCCA22E845F72; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22118845181844812%22%2C%22first_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhMTE2NmViYTM0MDUtMDIxZjQwZjczODg5YTg0LTdjNTQ2NDdlLTEzMjcxMDQtMThhMTE2NmViYTQzMjIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxMTg4NDUxODE4NDQ4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22118845181844812%22%7D%2C%22%24device_id%22%3A%2218a1166eba3405-021f40f73889a84-7c54647e-1327104-18a1166eba4322%22%7D");
        httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
        String jsonParam="{\"req_data\":{\"text\":\"认真工作\\n\",\"image_ids\":[]}}";
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
    @Test
    public void testChatGpt() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.closeai-asia.com/v1/chat/completions");
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization","Bearer sk-q3fw3JYNQkjE3wnUTesJbOa6GO346HDcVCVtSRk38osX7wEV");
        String jsonParam="{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [{\"role\": \"user\", \"content\": \"帮我写一个冒泡排序\"}]}";
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

}
