package cn.foxluo.alumni_club.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_message")
public class UserMessage {
    @Id
    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "send_u_id")
    private Integer sendUId;

    @Column(name = "object_u_id")
    private Integer objectUId;

    @Column(name = "message_send_time")
    private Date messageSendTime;

    @Column(name = "message_content")
    private String messageContent;

    /**
     * 信息内容 0:文本消息,1:图片消息,2:视频消息,3:语音消息
     */
    @Column(name = "message_type")
    private Integer messageType;

    /**
     * 消息状态 0:未接收,1:已接收
     */
    @Column(name = "message_state")
    private Integer messageState;

    /**
     * @return message_id
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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
     * @return message_send_time
     */
    public Date getMessageSendTime() {
        return messageSendTime;
    }

    /**
     * @param messageSendTime
     */
    public void setMessageSendTime(Date messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    /**
     * @return message_content
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * @param messageContent
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * 获取信息内容 0:文本消息,1:图片消息,2:视频消息,3:语音消息
     *
     * @return message_type - 信息内容 0:文本消息,1:图片消息,2:视频消息,3:语音消息
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * 设置信息内容 0:文本消息,1:图片消息,2:视频消息,3:语音消息
     *
     * @param messageType 信息内容 0:文本消息,1:图片消息,2:视频消息,3:语音消息
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * 获取消息状态 0:未接收,1:已接收
     *
     * @return message_state - 消息状态 0:未接收,1:已接收
     */
    public Integer getMessageState() {
        return messageState;
    }

    /**
     * 设置消息状态 0:未接收,1:已接收
     *
     * @param messageState 消息状态 0:未接收,1:已接收
     */
    public void setMessageState(Integer messageState) {
        this.messageState = messageState;
    }
}