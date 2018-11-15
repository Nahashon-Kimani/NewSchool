package com.nahashon.school;

public class Topic {

    public String topic_name;
    public String topic_desc;
    public String topic_link;



    public Topic() {
        

    }

    public Topic(String name, String description,String topic_link) {
        this.topic_name = name;
        this.topic_desc = description;
        this.topic_link = topic_link;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getTopic_desc() {
        return topic_desc;
    }

    public void setTopic_desc(String topic_desc) {
        this.topic_desc = topic_desc;
    }

    public String getTopic_link() {
        return topic_link;
    }

    public void setTopic_link(String topic_link) {
        this.topic_link = topic_link;
    }
}
