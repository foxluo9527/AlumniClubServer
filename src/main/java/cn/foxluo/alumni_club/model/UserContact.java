package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_contact")
public class UserContact {
    @Id
    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "object_u_id")
    private Integer objectUId;

    /**
     * 备注名，默认用户名称
     */
    @Column(name = "object_u_name")
    private String objectUName;

    @Column(name = "object_u_head")
    private String objectUHead;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return contact_id
     */
    public Integer getContactId() {
        return contactId;
    }

    /**
     * @param contactId
     */
    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return object_u_id
     */
    public Integer getObjectUId() {
        return objectUId;
    }

    /**
     * @param objectUId
     */
    public void setObjectUId(Integer objectUId) {
        this.objectUId = objectUId;
    }

    /**
     * 获取备注名，默认用户名称
     *
     * @return object_u_name - 备注名，默认用户名称
     */
    public String getObjectUName() {
        return objectUName;
    }

    /**
     * 设置备注名，默认用户名称
     *
     * @param objectUName 备注名，默认用户名称
     */
    public void setObjectUName(String objectUName) {
        this.objectUName = objectUName;
    }

    /**
     * @return object_u_head
     */
    public String getObjectUHead() {
        return objectUHead;
    }

    /**
     * @param objectUHead
     */
    public void setObjectUHead(String objectUHead) {
        this.objectUHead = objectUHead;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}