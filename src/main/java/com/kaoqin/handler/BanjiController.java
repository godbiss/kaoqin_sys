package com.kaoqin.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Banji;
import com.kaoqin.service.BanjiService;
import com.kaoqin.socket.WebSocketServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class BanjiController {

    @Autowired
    private BanjiService banjiService;


    @RequestMapping(value = "/banji/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Banji> listBanji() throws IOException {

        return banjiService.listBanji();

    }

    @RequestMapping(value = "/banji/admin/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteBanjiById(@PathVariable Integer id){
        JSONObject res = new JSONObject();
        if(banjiService.deleteBanji(id) != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }

    @RequestMapping(value = "/banji/admin/add", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject addBanjiForAdmin(@RequestBody Banji banji){
        JSONObject res = new JSONObject();
        if(banjiService.addBanji(banji) != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }

    @RequestMapping(value = "/banji/admin/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateBanjiForAdmin(@RequestBody Banji banji){
        JSONObject res = new JSONObject();

        if(banjiService.updateBanji(banji) != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }
}
