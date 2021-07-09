package com.kaoqin.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Banji;
import com.kaoqin.service.BanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BanjiController {

    @Autowired
    private BanjiService banjiService;


    @RequestMapping(value = "/banji/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Banji> listBanji(){
        return banjiService.listBanji();

    }

}
