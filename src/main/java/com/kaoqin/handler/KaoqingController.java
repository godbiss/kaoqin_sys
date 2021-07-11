package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Kaoqinlog;
import com.kaoqin.pojo.User;
import com.kaoqin.service.KaoqingService;
import com.kaoqin.service.UserService;
import com.kaoqin.socket.WebSocketServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KaoqingController {

    @Autowired
    private KaoqingService kaoqingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/kaoqinlog/teacher/list", method = RequestMethod.GET)
    @ResponseBody
    public List<JSONObject> listKaoqinlog(@RequestParam("banjinum") String banjinum,
                                         @RequestParam("kechengname") String kechengname,
                                         @RequestParam("riqi") String riqi,
                                         @RequestParam("teacher") String teacher) throws IOException {
        kechengname = new String(kechengname.getBytes("iso8859-1"),"utf-8");
        kaoqingService.generateKaoqinglogIfNotExist(banjinum, kechengname, riqi, teacher);
        List<Kaoqinlog> kaoqinlogList = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(banjinum, kechengname, riqi, teacher);

        List<JSONObject> jsonObjectList = new ArrayList<>();

        for (Kaoqinlog kaoqinlog:
             kaoqinlogList) {
            User userByCodenum = userService.getUserByCodenum(kaoqinlog.getCodenum());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("stdname", userByCodenum.getUsername());
            jsonObject.put("codenum", kaoqinlog.getCodenum());
            jsonObject.put("banjinum", kaoqinlog.getBanjinum());
            jsonObject.put("banjiname", userByCodenum.getBanji().getBanjiname());
            jsonObject.put("isKuangke", kaoqinlog.getIskuangke());
            jsonObject.put("kuangkenum", kaoqinlog.getKuangkenum());

            jsonObjectList.add(jsonObject);
        }

        WebSocketServlet webSocketServlet = new WebSocketServlet();
        webSocketServlet.broadcast("后台消息！");
        return jsonObjectList;
    }

}
