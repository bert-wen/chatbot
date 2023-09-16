package com.sveinn.chatbotdomain.zsxq.module.vo;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.vo
 * @className: Group
 * @author: WenHui
 * @description: TODO
 * @date: 2023/8/20 19:59
 * @version: 1.0
 */
public class Group {

    private String group_id;

    private String name;

    private String type;

    public void setGroup_id(String group_id){
        this.group_id = group_id;
    }
    public String getGroup_id(){
        return this.group_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

}
