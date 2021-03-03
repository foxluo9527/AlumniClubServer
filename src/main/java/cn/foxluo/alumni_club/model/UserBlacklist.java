package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_blacklist")
public class UserBlacklist {
    @Id
    @Column(name = "user_blacklist_id")
    private Integer userBlacklistId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "object_u_id")
    private Integer objectUId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return user_blacklist_id
     */
    public Integer getUserBlacklistId() {
        return userBlacklistId;
    }

    /**
     * @param userBlacklistId
     */
    public void setUserBlacklistId(Integer userBlacklistId) {
        this.userBlacklistId = userBlacklistId;
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