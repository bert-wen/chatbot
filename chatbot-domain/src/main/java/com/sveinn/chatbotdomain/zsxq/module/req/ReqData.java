package com.sveinn.chatbotdomain.zsxq.module.req;

/**
 * @projectName: chatbot
 * @package: com.sveinn.chatbotdomain.zsxq.module.req
 * @className: ReqData
 * @author: WenHui
 * @description: 请求对象
 * @date: 2023/8/20 20:32
 * @version: 1.0
 */
public class ReqData {

    private String text;
    private String[] image_ids = new String[]{};
    private boolean silenced;

    public ReqData(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }
}
