package com.sveinn;



import com.alibaba.fastjson.JSON;
import com.sveinn.chatbotdomain.ai.model.aggregates.Answer;
import com.sveinn.chatbotdomain.ai.service.OpenAI;
import com.sveinn.chatbotdomain.zsxq.module.aggregates.UnAnsweredQuestionsAggregates;
import com.sveinn.chatbotdomain.zsxq.module.vo.Topics;
import com.sveinn.chatbotdomain.zsxq.service.ZsxqApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotinterfaces
 * @className: SpringBootTest
 * @author: WenHui
 * @description: TODO
 * @date: 2023/8/20 21:27
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Value("${chat-bot.groupId}")
    private String groupId;
    @Value("${chat-bot.cookie}")
    private String cookie;

    @Resource
    private ZsxqApi zsxqApi;
    @Resource
    private OpenAI openAI;
    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnswerQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);
        }
    }
    @Test
    public void testCloseAI() throws IOException {
        Answer answer = openAI.getAnswer("用java写一个冒泡排序");
        logger.error("返回值{}",answer);
    }

}
