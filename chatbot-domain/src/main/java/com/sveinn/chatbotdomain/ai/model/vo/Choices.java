package com.sveinn.chatbotdomain.ai.model.vo;

import com.sveinn.chatbotdomain.ai.model.aggregates.Message;
import lombok.Data;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.ai.model.vo
 * @className: Choices
 * @author: WenHui
 * @description: TODO
 * @date: 2023/9/16 0:18
 * @version: 1.0
 */
@Data
public class Choices {
    private String index;
    private String content;
    private Message message;
}
