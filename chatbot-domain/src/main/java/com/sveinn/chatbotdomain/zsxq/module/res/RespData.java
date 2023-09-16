package com.sveinn.chatbotdomain.zsxq.module.res;

import com.sveinn.chatbotdomain.zsxq.module.vo.Topics;

import java.util.List;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.res
 * @className: RespData
 * @author: WenHui
 * @description: 返回数据
 * @date: 2023/8/20 20:43
 * @version: 1.0
 */
public class RespData {

    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

}