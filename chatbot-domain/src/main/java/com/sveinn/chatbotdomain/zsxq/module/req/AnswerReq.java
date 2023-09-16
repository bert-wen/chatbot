package com.sveinn.chatbotdomain.zsxq.module.req;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.req
 * @className: AnswerReq
 * @author: WenHui
 * @description: 请求问答接口信息
 * @date: 2023/8/20 21:18
 * @version: 1.0
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }

}
