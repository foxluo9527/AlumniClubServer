package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "community_post_comment_zan")
public class CommunityPostCommentZan {
    @Id
    @Column(name = "community_post_comment_zan_id")
    private Integer communityPostCommentZanId;

    @Column(name = "community_post_comment_id")
    private Integer communityPostCommentId;

    /**
     * 回复人id
     */
    @Column(name = "zan_u_id")
    private Integer zanUId;

    @Column(name = "zan_u_name")
    private String zanUName;

    @Column(name = "zan_u_head")
    private String zanUHead;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return community_post_comment_zan_id
     */
    public Integer getCommunityPostCommentZanId() {
        return communityPostCommentZanId;
    }

    /**
     * @param communityPostCommentZanId
     */
    public void setCommunityPostCommentZanId(Integer communityPostCommentZanId) {
        this.communityPostCommentZanId = communityPostCommentZanId;
    }

    /**
     * @return community_post_comment_id
     */
    public Integer getCommunityPostCommentId() {
        return communityPostCommentId;
    }

    /**
     * @param communityPostCommentId
     */
    public void setCommunityPostCommentId(Integer communityPostCommentId) {
        this.communityPostCommentId = communityPostCommentId;
    }

    /**
     * 获取回复人id
     *
     * @return zan_u_id - 回复人id
     */
    public Integer getZanUId() {
        return zanUId;
    }

    /**
     * 设置回复人id
     *
     * @param zanUId 回复人id
     */
    public void setZanUId(Integer zanUId) {
        this.zanUId = zanUId;
    }

    /**
     * @return zan_u_name
     */
    public String getZanUName() {
        return zanUName;
    }

    /**
     * @param zanUName
     */
    public void setZanUName(String zanUName) {
        this.zanUName = zanUName;
    }

    /**
     * @return zan_u_head
     */
    public String getZanUHead() {
        return zanUHead;
    }

    /**
     * @param zanUHead
     */
    public void setZanUHead(String zanUHead) {
        this.zanUHead = zanUHead;
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