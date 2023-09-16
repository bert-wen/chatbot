package com.sveinn.chatbotdomain.zsxq.module.vo;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.vo
 * @className: UserSpecific
 * @author: WenHui
 * @description: TODO
 * @date: 2023/8/20 20:31
 * @version: 1.0
 */
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }

}
