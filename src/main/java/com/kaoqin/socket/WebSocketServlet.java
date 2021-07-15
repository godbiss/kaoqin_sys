package com.kaoqin.socket;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.User;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint("/websocket/{id}/{username}")
@Component
public class WebSocketServlet {
    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServlet> webSocketSet = new CopyOnWriteArraySet<WebSocketServlet>();
    private static Map<User, WebSocketServlet> userWebSocketServletMap = new HashMap<>();
    private  javax.websocket.Session session=null;
    private Integer userid;
    private String username;
    private User user;

    /**
     * @ClassName: onOpen
     * @Description: 开启连接的操作
     */
    @OnOpen
    public void onOpen(@PathParam("id")Integer id, @PathParam("username")String username, Session session, EndpointConfig config) throws IOException{
        //获取WebsocketConfig.java中配置的“sessionId”信息值
        String httpSessionId = (String) config.getUserProperties().get("sessionId");
        this.session=session;
        this.userid = id;
        this.username = new String(username.getBytes("iso8859-1"), "utf-8");
        User user = new User();
        user.setId(id);
        user.setUsername(this.username);
        this.user = user;
        userWebSocketServletMap.put(this.user, this);
        webSocketSet.add(this);

    }

    /**
     * @ClassName: onClose
     * @Description: 连接关闭的操作
     */
    @OnClose
    public void onClose() throws IOException {
        userWebSocketServletMap.remove(this.user);
        webSocketSet.remove(this);
//        session.close();
    }

    /**
     * 告知前端数据库发生变化，调用sendMessage()方法
     * @param count
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        // { msg: "", from:"", to:""}
        JSONObject jsonObject = JSONObject.parseObject(message);
        String msg = (String) jsonObject.get("msg");
        if(jsonObject.get("to") == null && jsonObject.get("to") == ""){
            broadcast(message);
        }else {
            String[] ids = jsonObject.get("to").toString().split(",");
            for (int i = 0; i < ids.length; i++) {
                sendMessageTo(message, ids[i]);
            }
        }
    }

    /**
     * 出错操作
     * @param error
     */
    @OnError
    public void onError(Throwable error) throws IOException {
        onClose();
        error.printStackTrace();
    }

    public void broadcast(String message) throws IOException {
        for (WebSocketServlet item : userWebSocketServletMap.values()) {
                item.session.getBasicRemote().sendText(message);
        }
    }

    public void sendMessageTo(String message, String To) throws IOException {
        for (WebSocketServlet item : userWebSocketServletMap.values()) {
            if (item.userid.equals(To) )
                item.session.getBasicRemote().sendText(message);
        }
    }
}
