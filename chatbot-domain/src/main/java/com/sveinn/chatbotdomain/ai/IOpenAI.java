package com.sveinn.chatbotdomain.ai;

import com.sveinn.chatbotdomain.ai.model.aggregates.Answer;

import java.io.IOException;

/**
 * @author WenHui
 * @description OpenAI接口 https://api.closeai-asia.com/v1/chat/completions
 * @date 2023/9/16 0:02
 */

public interface IOpenAI {
   public String getAnswer(String question) throws IOException;
}
