package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.User;
import com.kaoqin.service.UserService;
import com.kaoqin.socket.WebSocketServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class WebSocketController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/alert", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject alertUserToSign(@RequestBody JSONObject req) throws IOException {
        JSONObject res = new JSONObject();

        User std = userService.getUserByCodenum((String) req.get("codenum"));

        WebSocketServlet webSocketServlet = new WebSocketServlet();
        webSocketServlet.sendMessageTo("上课签到提醒!", std.getId());

        System.out.println(req);

        res.put("success", true);
        return res;
    }
}
