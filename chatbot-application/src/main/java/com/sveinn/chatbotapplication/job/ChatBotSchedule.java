package com.sveinn.chatbotapplication.job;

import com.sveinn.chatbotdomain.ai.model.aggregates.Answer;
import com.sveinn.chatbotdomain.ai.service.OpenAI;
import com.sveinn.chatbotdomain.zsxq.module.aggregates.UnAnsweredQuestionsAggregates;
import com.sveinn.chatbotdomain.zsxq.module.vo.Topics;
import com.sveinn.chatbotdomain.zsxq.service.ZsxqApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotapplication.job
 * @className: ChatBotSchedule
 * @author: WenHui
 * @description: 问题任务
 * @date: 2023/9/18 0:40
 * @version: 1.0
 */
@EnableScheduling
@Configuration
public class ChatBotSchedule {

    private Logger logger= LoggerFactory.getLogger(ChatBotSchedule.class);
    @Value("${chat-bot.closeAiKey}")
    private String closeAiKey;
    @Value("${chat-bot.groupId}")
    private String groupId;
    @Value("${chat-bot.cookie}")
    private String cookie;
    @Resource
    private OpenAI openAI;
    @Resource
    private ZsxqApi zsxqApi;

    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){
        try {
            if (new Random().nextBoolean()){
                logger.error("随机打烊中.....");
            }
            // 1.检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi
                    .queryUnAnswerQuestionsTopicId(groupId, cookie);
            logger.info("知识星球问题返回内容:{}" ,unAnsweredQuestionsAggregates);
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if (topics==null || topics.isEmpty()){
                logger.error("本次未检索到要回答的问题....");
                return;
            }
            // 2.AI回答
            Topics topic= topics.get(0);
            Answer answer = openAI.getAnswer(topic.getQuestion().getText().trim());
            // 解析回答的问题
            String content = answer.getChoices().get(0).getMessage().getContent();
            boolean state = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), content, false);
            logger.info("编号:{},问题:{},回答:{},状态:{}",topic.getTopic_id(),topic.getQuestion().getText().trim()
            ,content,state);
        } catch (IOException e) {
            logger.error("自动回答问题失败");
        }

    }
}
