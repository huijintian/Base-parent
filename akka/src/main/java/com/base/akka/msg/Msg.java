package com.base.akka.msg;

/**
 * Created by mengtian on 2017/11/7
 */
public class Msg {
    private Message type;
    private String desc;

    public Msg(Message type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Message getType() {
        return type;
    }

    public void setType(Message type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "type=" + type +
                ", desc='" + desc + '\'' +
                '}';
    }
}
