package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "u_name")
    private String uName;

    @Column(name = "u_nick_name")
    private String uNickName;

    @Column(name = "u_real_name")
    private String uRealName;

    @Column(name = "u_head")
    private String uHead;

    @Column(name = "u_phone")
    private String uPhone;

    @Column(name = "u_password")
    private String uPassword;

    @Column(name = "u_local_id")
    private String uLocalId;

    /**
     * 所在地，省名
     */
    @Column(name = "u_local_name")
    private String uLocalName;

    @Column(name = "u_university_id")
    private Integer uUniversityId;

    @Column(name = "u_university_name")
    private String uUniversityName;

    @Column(name = "u_sex")
    private String uSex;

    @Column(name = "u_birthday")
    private Date uBirthday;

    @Column(name = "u_description")
    private String uDescription;

    /**
     * 资料卡隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     */
    @Column(name = "u_privacy_msg")
    private Integer uPrivacyMsg;

    /**
     * 用户查看空间隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     */
    @Column(name = "u_privacy_zone_user")
    private Integer uPrivacyZoneUser;

    /**
     * 查看用户空间时间区间隐私权限 0:随时可见,1:指定日期后可见,2:指定时间内可见
     */
    @Column(name = "u_privacy_zone_time")
    private Integer uPrivacyZoneTime;

    /**
     * 用户空间可见时效截至日期，日期前不可见
     */
    @Column(name = "u_privacy_zone_time_date")
    private Date uPrivacyZoneTimeDate;

    /**
     * 用户空间可见时效天数
     */
    @Column(name = "u_privacy_zone_time_time")
    private Integer uPrivacyZoneTimeTime;

    /**
     * 0:未禁用，1:禁用
     */
    @Column(name = "u_enable")
    private Integer uEnable;

    @Column(name = "u_create_time")
    private Date uCreateTime;

    /**
     * @return u_id
     */
    public Integer getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    /**
     * @return u_name
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * @return u_nick_name
     */
    public String getuNickName() {
        return uNickName;
    }

    /**
     * @param uNickName
     */
    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    /**
     * @return u_real_name
     */
    public String getuRealName() {
        return uRealName;
    }

    /**
     * @param uRealName
     */
    public void setuRealName(String uRealName) {
        this.uRealName = uRealName;
    }

    /**
     * @return u_head
     */
    public String getuHead() {
        return uHead;
    }

    /**
     * @param uHead
     */
    public void setuHead(String uHead) {
        this.uHead = uHead;
    }

    /**
     * @return u_phone
     */
    public String getuPhone() {
        return uPhone;
    }

    /**
     * @param uPhone
     */
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    /**
     * @return u_password
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * @param uPassword
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    /**
     * @return u_local_id
     */
    public String getuLocalId() {
        return uLocalId;
    }

    /**
     * @param uLocalId
     */
    public void setuLocalId(String uLocalId) {
        this.uLocalId = uLocalId;
    }

    /**
     * 获取所在地，省名
     *
     * @return u_local_name - 所在地，省名
     */
    public String getuLocalName() {
        return uLocalName;
    }

    /**
     * 设置所在地，省名
     *
     * @param uLocalName 所在地，省名
     */
    public void setuLocalName(String uLocalName) {
        this.uLocalName = uLocalName;
    }

    /**
     * @return u_university_id
     */
    public Integer getuUniversityId() {
        return uUniversityId;
    }

    /**
     * @param uUniversityId
     */
    public void setuUniversityId(Integer uUniversityId) {
        this.uUniversityId = uUniversityId;
    }

    /**
     * @return u_university_name
     */
    public String getuUniversityName() {
        return uUniversityName;
    }

    /**
     * @param uUniversityName
     */
    public void setuUniversityName(String uUniversityName) {
        this.uUniversityName = uUniversityName;
    }

    /**
     * @return u_sex
     */
    public String getuSex() {
        return uSex;
    }

    /**
     * @param uSex
     */
    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    /**
     * @return u_birthday
     */
    public Date getuBirthday() {
        return uBirthday;
    }

    /**
     * @param uBirthday
     */
    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    /**
     * @return u_description
     */
    public String getuDescription() {
        return uDescription;
    }

    /**
     * @param uDescription
     */
    public void setuDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    /**
     * 获取资料卡隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     *
     * @return u_privacy_msg - 资料卡隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     */
    public Integer getuPrivacyMsg() {
        return uPrivacyMsg;
    }

    /**
     * 设置资料卡隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     *
     * @param uPrivacyMsg 资料卡隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     */
    public void setuPrivacyMsg(Integer uPrivacyMsg) {
        this.uPrivacyMsg = uPrivacyMsg;
    }

    /**
     * 获取用户查看空间隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     *
     * @return u_privacy_zone_user - 用户查看空间隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     */
    public Integer getuPrivacyZoneUser() {
        return uPrivacyZoneUser;
    }

    /**
     * 设置用户查看空间隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     *
     * @param uPrivacyZoneUser 用户查看空间隐私权限 0:任何人可见,1:好友可见,2:任何人不可见
     */
    public void setuPrivacyZoneUser(Integer uPrivacyZoneUser) {
        this.uPrivacyZoneUser = uPrivacyZoneUser;
    }

    /**
     * 获取查看用户空间时间区间隐私权限 0:随时可见,1:指定日期后可见,2:指定时间内可见
     *
     * @return u_privacy_zone_time - 查看用户空间时间区间隐私权限 0:随时可见,1:指定日期后可见,2:指定时间内可见
     */
    public Integer getuPrivacyZoneTime() {
        return uPrivacyZoneTime;
    }

    /**
     * 设置查看用户空间时间区间隐私权限 0:随时可见,1:指定日期后可见,2:指定时间内可见
     *
     * @param uPrivacyZoneTime 查看用户空间时间区间隐私权限 0:随时可见,1:指定日期后可见,2:指定时间内可见
     */
    public void setuPrivacyZoneTime(Integer uPrivacyZoneTime) {
        this.uPrivacyZoneTime = uPrivacyZoneTime;
    }

    /**
     * 获取用户空间可见时效截至日期，日期前不可见
     *
     * @return u_privacy_zone_time_date - 用户空间可见时效截至日期，日期前不可见
     */
    public Date getuPrivacyZoneTimeDate() {
        return uPrivacyZoneTimeDate;
    }

    /**
     * 设置用户空间可见时效截至日期，日期前不可见
     *
     * @param uPrivacyZoneTimeDate 用户空间可见时效截至日期，日期前不可见
     */
    public void setuPrivacyZoneTimeDate(Date uPrivacyZoneTimeDate) {
        this.uPrivacyZoneTimeDate = uPrivacyZoneTimeDate;
    }

    /**
     * 获取用户空间可见时效天数
     *
     * @return u_privacy_zone_time_time - 用户空间可见时效天数
     */
    public Integer getuPrivacyZoneTimeTime() {
        return uPrivacyZoneTimeTime;
    }

    /**
     * 设置用户空间可见时效天数
     *
     * @param uPrivacyZoneTimeTime 用户空间可见时效天数
     */
    public void setuPrivacyZoneTimeTime(Integer uPrivacyZoneTimeTime) {
        this.uPrivacyZoneTimeTime = uPrivacyZoneTimeTime;
    }

    /**
     * 获取0:未禁用，1:禁用
     *
     * @return u_enable - 0:未禁用，1:禁用
     */
    public Integer getuEnable() {
        return uEnable;
    }

    /**
     * 设置0:未禁用，1:禁用
     *
     * @param uEnable 0:未禁用，1:禁用
     */
    public void setuEnable(Integer uEnable) {
        this.uEnable = uEnable;
    }

    /**
     * @return u_create_time
     */
    public Date getuCreateTime() {
        return uCreateTime;
    }

    /**
     * @param uCreateTime
     */
    public void setuCreateTime(Date uCreateTime) {
        this.uCreateTime = uCreateTime;
    }
}