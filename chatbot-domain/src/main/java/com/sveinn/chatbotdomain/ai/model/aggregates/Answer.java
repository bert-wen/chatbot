package com.sveinn.chatbotdomain.ai.model.aggregates;

import com.sveinn.chatbotdomain.ai.model.vo.Choices;
import lombok.Data;

import java.util.List;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.ai.model.aggregates
 * @className: Answer
 * @author: WenHui
 * @description: chatGPT返回对象
 * @date: 2023/9/16 0:15
 * @version: 1.0
 */
@Data
public class Answer {
    private String id;
    private String object;
    private String created;
    private String model;
    List<Choices> choices;
}
