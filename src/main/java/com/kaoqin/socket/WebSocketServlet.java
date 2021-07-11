package com.kaoqin.socket;

import com.alibaba.fastjson.JSON;
import com.kaoqin.pojo.User;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{id}")
@Component
public class WebSocketServlet {

    private static int onlineCount = 0;
    public static Map<User, WebSocketServlet> clients = new ConcurrentHashMap<User, WebSocketServlet>();
    private Session session;
    private Integer userId;//用户id
    private String username;//用户真实名称
    private User user;//用户实体
    public static List<User> list = new ArrayList<>();   //在线列表,记录用户名称

    /**
     * @ClassName: onOpen
     * @Description: 开启连接的操作
     */
    @OnOpen
    public void onOpen(@PathParam("id") Integer userId, Session session) throws IOException{

        this.userId = userId;
        this.session = session;
//        this.username= new String(cnName.getBytes("iso8859-1"), "utf-8");
//        System.out.println("cnName:"+cnName+"userId"+userId);
        user= new User();
        user.setId(userId);
//        user.setUsername(cnName);
        list.add(user);
        addOnlineCount();//添加在线人数
        clients.put(user, this);


    }

    /**
     * 广播消息
     * @param message
     */
    public void broadcast(String message){
        for (WebSocketServlet item : clients.values()) {
            String cnName = item.username;
            //
            String msg = message.replace("{userName}",cnName);
            item.session.getAsyncRemote().sendText(msg);
        }
    }

    /**
     * 组装返回给前台的消息
     * @param message   交互信息
     * @param type      信息类型
     * @param list      在线列表
     * @return
     */
    public String getMessage(String message, String type, List list){
        com.alibaba.fastjson.JSONObject member = new com.alibaba.fastjson.JSONObject();
        member.put("message", message);
        member.put("type", type);
        member.put("list", list);
        return member.toString();
    }

    /**
     * 对特定用户发送消息
     * @param message
     * @param session
     */
    public void singleSend(String message, Session session){
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @ClassName: onClose
     * @Description: 连接关闭的操作
     */
    @OnClose
    public void onClose(){
        System.out.println("关闭当前用户连接："+user.getUsername());
        clients.remove(user);
        list.remove(user);        //从在线列表移除这个用户
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String _message) throws IOException {
        com.alibaba.fastjson.JSONObject chat = JSON.parseObject(_message);
        com.alibaba.fastjson.JSONObject message = JSON.parseObject(chat.get("message").toString());
        if(message.get("to") == null || message.get("to").equals("")){
            //如果to为空,则广播;如果不为空,则对指定的用户发送消息
            broadcast(_message);
        }else{
            String [] userlist = message.get("to").toString().split(",");
//            sendMessageTo(_message,message.get("from").toString());
//            singleSend(_message, (Session) routetab.get(message.get("from"))); //发送给自己
            for (String userid:
                 userlist) {
                sendMessageTo(_message,message.get("to").toString());
            }
        }
    }

    /**
     * 出错操作
     * @param error
     */
    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }

    /**
     *@description:消息发送给指定人员
     *@author:cyb
     *@date: 2018-12-03 14:35
     *@param: message
    *@param: To
     *@return: void
     */
    public void sendMessageTo(String message, String To) throws IOException {
        for (WebSocketServlet item : clients.values()) {
            if (item.userId.equals(To) )
                item.session.getAsyncRemote().sendText(message);
        }
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    public static synchronized void addOnlineCount() {
        WebSocketServlet.onlineCount++;
    }
    public static synchronized void subOnlineCount() {
        WebSocketServlet.onlineCount--;
    }
    public static synchronized Map<User, WebSocketServlet> getClients() {
        return clients;
    }
}
