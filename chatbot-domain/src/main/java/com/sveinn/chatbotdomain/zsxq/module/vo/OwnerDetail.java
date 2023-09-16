package com.sveinn.chatbotdomain.zsxq.module.vo;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.vo
 * @className: OwnerDetail
 * @author: WenHui
 * @description: TODO
 * @date: 2023/8/20 20:11
 * @version: 1.0
 */
public class OwnerDetail {

    private int questions_count;

    private String join_time;

    public void setQuestions_count(int questions_count){
        this.questions_count = questions_count;
    }
    public int getQuestions_count(){
        return this.questions_count;
    }
    public void setJoin_time(String join_time){
        this.join_time = join_time;
    }
    public String getJoin_time(){
        return this.join_time;
    }

}
