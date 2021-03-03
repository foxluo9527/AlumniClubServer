package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "community_post_zan")
public class CommunityPostZan {
    @Id
    @Column(name = "community_post_zan_id")
    private Integer communityPostZanId;

    @Column(name = "community_post_id")
    private Integer communityPostId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return community_post_zan_id
     */
    public Integer getCommunityPostZanId() {
        return communityPostZanId;
    }

    /**
     * @param communityPostZanId
     */
    public void setCommunityPostZanId(Integer communityPostZanId) {
        this.communityPostZanId = communityPostZanId;
    }

    /**
     * @return community_post_id
     */
    public Integer getCommunityPostId() {
        return communityPostId;
    }

    /**
     * @param communityPostId
     */
    public void setCommunityPostId(Integer communityPostId) {
        this.communityPostId = communityPostId;
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