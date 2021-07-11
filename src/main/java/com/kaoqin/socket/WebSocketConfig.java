package com.kaoqin.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @Author: Wxz
 * @Date: 2020/9/1 11:49
 */
@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        /*如果没有监听器,那么这里获取到的HttpSession是null*/
        Object session = request.getHttpSession();
        if (session != null) {
            HttpSession httpSession = (HttpSession) request.getHttpSession();
            //关键操作
            sec.getUserProperties().put("sessionId", httpSession.getId());
        }
    }


//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
}
