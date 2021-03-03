package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "community_post_comment")
public class CommunityPostComment {
    @Id
    @Column(name = "community_post_comment_id")
    private Integer communityPostCommentId;

    @Column(name = "community_post_id")
    private Integer communityPostId;

    @Column(name = "send_u_id")
    private Integer sendUId;

    @Column(name = "send_u_name")
    private String sendUName;

    @Column(name = "send_u_head")
    private String sendUHead;

    @Column(name = "community_post_comment_content")
    private String communityPostCommentContent;

    /**
     * 热度值:点赞+1，回复+1
     */
    @Column(name = "hot_value")
    private Integer hotValue;

    @Column(name = "zan_num")
    private Integer zanNum;

    /**
     * 0:待审核,1:通过,2:未通过
     */
    private Integer state;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return send_u_id
     */
    public Integer getSendUId() {
        return sendUId;
    }

    /**
     * @param sendUId
     */
    public void setSendUId(Integer sendUId) {
        this.sendUId = sendUId;
    }

    /**
     * @return send_u_name
     */
    public String getSendUName() {
        return sendUName;
    }

    /**
     * @param sendUName
     */
    public void setSendUName(String sendUName) {
        this.sendUName = sendUName;
    }

    /**
     * @return send_u_head
     */
    public String getSendUHead() {
        return sendUHead;
    }

    /**
     * @param sendUHead
     */
    public void setSendUHead(String sendUHead) {
        this.sendUHead = sendUHead;
    }

    /**
     * @return community_post_comment_content
     */
    public String getCommunityPostCommentContent() {
        return communityPostCommentContent;
    }

    /**
     * @param communityPostCommentContent
     */
    public void setCommunityPostCommentContent(String communityPostCommentContent) {
        this.communityPostCommentContent = communityPostCommentContent;
    }

    /**
     * 获取热度值:点赞+1，回复+1
     *
     * @return hot_value - 热度值:点赞+1，回复+1
     */
    public Integer getHotValue() {
        return hotValue;
    }

    /**
     * 设置热度值:点赞+1，回复+1
     *
     * @param hotValue 热度值:点赞+1，回复+1
     */
    public void setHotValue(Integer hotValue) {
        this.hotValue = hotValue;
    }

    /**
     * @return zan_num
     */
    public Integer getZanNum() {
        return zanNum;
    }

    /**
     * @param zanNum
     */
    public void setZanNum(Integer zanNum) {
        this.zanNum = zanNum;
    }

    /**
     * 获取0:待审核,1:通过,2:未通过
     *
     * @return state - 0:待审核,1:通过,2:未通过
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0:待审核,1:通过,2:未通过
     *
     * @param state 0:待审核,1:通过,2:未通过
     */
    public void setState(Integer state) {
        this.state = state;
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