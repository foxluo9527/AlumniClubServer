package cn.foxluo.alumni_club.configurer;

import cn.foxluo.alumni_club.model.User;
import cn.foxluo.alumni_club.util.TokenUtil;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> attributes) {
        if (request instanceof ServletServerHttpRequest) {
            String loginToken = ((ServletServerHttpRequest) request).getServletRequest().getParameter("token");
            User user = TokenUtil.getTokenUser(loginToken).getUser();
            if (user != null) {
                attributes.put("user", user);
                attributes.put("token", loginToken);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        super.afterHandshake(serverHttpRequest, serverHttpResponse, webSocketHandler, e);
    }
}