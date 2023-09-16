package com.sveinn.chatbotdomain.zsxq.module.aggregates;

import com.sveinn.chatbotdomain.zsxq.module.res.RespData;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.aggregates
 * @className: UnAnswerdQuestionsAggregates
 * @author: WenHui
 * @description: TODO
 * @date: 2023/8/20 20:39
 * @version: 1.0
 */

public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
