package cn.foxluo.alumni_club.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangePassParam {
    @ApiModelProperty(value = "用户手机号", required = true)
    private String phone;
    @ApiModelProperty(value = "手机验证码", required = true)
    private String code;
    @ApiModelProperty(value = "新密码", required = true)
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

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
