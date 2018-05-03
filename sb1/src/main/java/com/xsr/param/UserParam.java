package com.xsr.param;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * Created by 145811 on 2018/3/27.
 */
public class UserParam {
    @NotBlank(message="名字不能为空")
    @ApiModelProperty(value = "名称",required = true)
    private String name;
    @Min(value = 18, message = "年龄必须大于18")
    @ApiModelProperty(value = "年龄",required = true)
    private int age;
    @ApiModelProperty(value = "单据号",required = true)
    @NotNull(message="密码不能为空")
    private String passwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
