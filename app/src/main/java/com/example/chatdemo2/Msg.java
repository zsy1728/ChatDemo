package com.example.chatdemo2;

public class Msg {
    public static final int TYPE_RECEIVED = 0;	//标记用于判断是输出消息还是接收消息
    public static final int TYPE_SENT = 1;
    private final String content;		//存储消息信息
    private final int type;	//存储判断信息
    private final String time;
    private final String name;
    private final int imageId;

    public Msg(String content, int type, String time,String name,int imageId) {
        this.content = content;
        this.type = type;
        this.time = time;
        this.name = name;
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public String getTime(){
        return time;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}


