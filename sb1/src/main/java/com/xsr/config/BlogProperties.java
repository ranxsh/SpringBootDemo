package com.xsr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 145811 on 2018/3/23.
 */
@Component
public class BlogProperties {
    @Value("${com.xsr.blog.name}")
    private String name;
    @Value("${com.xsr.blog.title}")
    private String title;
    @Value("${com.xsr.blog.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
