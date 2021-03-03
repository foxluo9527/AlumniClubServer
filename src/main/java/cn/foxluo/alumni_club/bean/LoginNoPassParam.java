package cn.foxluo.alumni_club.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginNoPassParam {
    @ApiModelProperty(value = "用户手机号",required = true)
    private String phone;
    @ApiModelProperty(value = "手机验证码",required = true)
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
