package cn.foxluo.alumni_club.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterBean {
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称",required = true)
    private String nickName;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别" ,required = true,dataType = "String")
    private String sex;
    /**
     * 地区id
     */
    @ApiModelProperty(value = "地区id(地区首字母缩写)",required = true,dataType = "String")
    private String localId;
    /**
     * 地区名称
     */
    @ApiModelProperty(value = "地区名称",required = true,dataType = "String")
    private String localName;
    /**
     * 学校id
     */
    @ApiModelProperty(value = "学校id",required = true,dataType = "int")
    private int schoolId;
    /**
     * 学校名称
     */
    @ApiModelProperty(value = "学校名称",required = true,dataType = "String")
    private String schoolName;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码",required = true,dataType = "String")
    private String phone;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码",required = true,dataType = "String")
    private String password;
    /**
     * 手机验证码
     */
    @ApiModelProperty(value = "手机验证码",required = true,dataType = "String")
    private String code;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
