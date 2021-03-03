package cn.foxluo.alumni_club.web;

import cn.foxluo.alumni_club.model.User;
import cn.foxluo.alumni_club.model.UserContact;
import cn.foxluo.alumni_club.model.UserMessage;
import cn.foxluo.alumni_club.service.UserContactService;
import cn.foxluo.alumni_club.service.impl.UserMessageServiceImpl;
import cn.foxluo.alumni_club.util.TokenUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MsgScoketHandle implements WebSocketHandler {
    @Autowired
    UserMessageServiceImpl messageService;
    @Autowired
    UserContactService userContactService;

    protected static final ArrayList<WebSocketSession> users;

    static {
        users = new ArrayList<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) {
        System.out.println("=====================建立连接成功==========================");
        User user = (User) webSocketSession.getAttributes().get("user");
        if (user != null) {
            System.out.println("当前连接用户======" + user.getuName());
        }
        try {
            for (WebSocketSession session : users) {
                assert user != null;
                if (((User) session.getAttributes().get("user")).getuId().equals(user.getuId())) {
                    String loginToken = TokenUtil.getUserToken(((User) session.getAttributes().get("user")));
                    if (!session.getAttributes().get("token").equals(loginToken)) {
                        //同一token重复登录暂不强制下线
                        JSONObject message = new JSONObject();
                        message.put("msgType", 4);
                        message.put("content", "非法登录，即将下线");
                        message.put("userId", ((User) session.getAttributes().get("user")).getuId());
                        message.put("loginToken", TokenUtil.getUserToken(((User) session.getAttributes().get("user"))));
                        session.sendMessage(new TextMessage(message.toJSONString()));
                    }
                    users.remove(session);
                    session.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.add(webSocketSession);
        System.out.println("webSocket连接数量=====" + users.size());
        if (messageService != null) {
            assert user != null;
            List<UserMessage> unReceiveMsgs = messageService.getUserAllMessage(user.getuId());
            for (UserMessage userMessage : unReceiveMsgs) {
                UserContact userContact = new UserContact();
                userContact.setUserId(userMessage.getObjectUId());
                userContact.setObjectUId(userMessage.getSendUId());
                if (userContactService.checkContact(userContact) > 0)
                    sendMessageToUser(userMessage);
            }
        }
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        users.remove(webSocketSession);
        User user = (User) webSocketSession.getAttributes().get("user");
        System.out.println(user.getuName() + "断开连接");
        if (webSocketSession.isOpen()) {
            //关闭session
            try {
                webSocketSession.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessageToUser(UserMessage messageInfo) {
        for (WebSocketSession session : users) {
            if (session.isOpen()) {
                User sessionUser = (User) session.getAttributes().get("user");
                if (sessionUser.getuId().equals(messageInfo.getObjectUId())) {
                    if (session.isOpen()) {
                        JSONObject message = new JSONObject();
                        message.put("msgType", 1);
                        message.put("content", JSONObject.toJSON(messageInfo));
                        try {
                            session.sendMessage(new TextMessage(message.toJSONString()));
                            System.out.println("发送消息给：" + sessionUser.getuName() + "内容：" + messageInfo.getMessageContent());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        messageService.receiveMessage(messageInfo);
                    }
                    break;
                }
            }
        }
    }


    public boolean getUserOnlineState(int u_id) {
        for (WebSocketSession session : users) {
            try {
                User sessionUser = (User) session.getAttributes().get("user");
                if (sessionUser != null) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}