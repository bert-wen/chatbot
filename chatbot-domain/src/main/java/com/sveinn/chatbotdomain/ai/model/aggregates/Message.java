package com.sveinn.chatbotdomain.ai.model.aggregates;

import lombok.Data;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.ai.model.aggregates
 * @className: Message
 * @author: WenHui
 * @description: TODO
 * @date: 2023/9/20 0:43
 * @version: 1.0
 */
@Data
public class Message {
    private String role;
    private String content;
    private String finishReason;
}
