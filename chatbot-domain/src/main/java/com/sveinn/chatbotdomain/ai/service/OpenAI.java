package com.sveinn.chatbotdomain.ai.service;

import com.alibaba.fastjson.JSON;
import com.sveinn.chatbotdomain.ai.IOpenAI;
import com.sveinn.chatbotdomain.ai.model.aggregates.Answer;
import com.sveinn.chatbotdomain.ai.model.vo.Choices;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.ai.service
 * @className: OpenAI
 * @author: WenHui
 * @description: 实现类
 * @date: 2023/9/16 0:13
 * @version: 1.0
 */
@Service
public class OpenAI implements IOpenAI {
    private Logger logger= LoggerFactory.getLogger(OpenAI.class);
    @Value("${chat-bot.closeAiKey}")
    private String closeAiKey;
    @Override
    public String getAnswer(String question) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.closeai-asia.com/v1/chat/completions");
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization","Bearer "+closeAiKey);
        String jsonParam="{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [{\"role\": \"user\", \"content\": \""+question+"\"}]}";
        StringEntity stringEntity = new StringEntity(jsonParam, ContentType.create("text/json", "UTF-8"));

        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            Answer  answer = JSON.parseObject(jsonStr, Answer.class);
            StringBuilder answers = new StringBuilder();
            for (Choices choice : answer.getChoices()) {
                answers.append(choice);
            }
            return answers.toString();
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
        return null;
    }
}
