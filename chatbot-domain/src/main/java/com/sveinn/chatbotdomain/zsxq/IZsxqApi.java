package com.sveinn.chatbotdomain.zsxq;

import com.sveinn.chatbotdomain.zsxq.module.aggregates.UnAnsweredQuestionsAggregates;


import java.io.IOException;

public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnswerQuestionsTopicId(String groupId, String cookie) throws IOException;
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
