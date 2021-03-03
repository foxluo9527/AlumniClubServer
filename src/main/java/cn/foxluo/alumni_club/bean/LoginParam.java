package cn.foxluo.alumni_club.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginParam {
    @ApiModelProperty(value = "用户名或手机号",required = true)
    private String username;
    @ApiModelProperty(value = "用户密码",required = true)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
