package com.kaoqin.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Banji;
import com.kaoqin.pojo.Course;
import com.kaoqin.pojo.Qingjiadan;
import com.kaoqin.service.BanjiService;
import com.kaoqin.service.CourseService;
import com.kaoqin.service.QingjiadanService;
import com.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class QingjiadanController {

    @Autowired
    private QingjiadanService qingjiadanService;

    @Autowired
    private BanjiService banjiService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/qingjiadan/std/add", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject addQingjiadanForStd(@RequestBody JSONObject req){
        String banjinum = (String) req.get("banjinum");
        String codenum = (String) req.get("codenum");
        String qjtime1 = (String) req.get("qjtime1");
        String qjtime2 = (String) req.get("qjtime2");
        String qingjiacontent = (String) req.get("qingjiacontent");
        String username = (String) req.get("username");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String[] ymdsplit = qjtime1.split(" ")[0].split("-");
        String[] hmssplit = qjtime1.split(" ")[1].split(":");

        String[] ymdsplit2 = qjtime2.split(" ")[0].split("-");
        String[] hmssplit2 = qjtime2.split(" ")[1].split(":");

        //引用日历类设置日期
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, Integer.parseInt(ymdsplit[0]));//设置年
        gc.set(Calendar.MONTH, Integer.parseInt(ymdsplit[1])-1);//这里0是1月..以此向后推
        gc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ymdsplit[2]));//设置天
        // 将时分秒,毫秒域清零
        gc.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hmssplit[0]));
        gc.set(Calendar.MINUTE, Integer.parseInt(hmssplit[1]));
        gc.set(Calendar.SECOND, Integer.parseInt(hmssplit[2]));

        //引用日历类设置日期
        GregorianCalendar gc2 = new GregorianCalendar();
        gc2.set(Calendar.YEAR, Integer.parseInt(ymdsplit2[0]));//设置年
        gc2.set(Calendar.MONTH, Integer.parseInt(ymdsplit2[1])-1);//这里0是1月..以此向后推
        gc2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ymdsplit2[2]));//设置天
        // 将时分秒,毫秒域清零
        gc2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hmssplit2[0]));
        gc2.set(Calendar.MINUTE, Integer.parseInt(hmssplit2[1]));
        gc2.set(Calendar.SECOND, Integer.parseInt(hmssplit2[2]));

        JSONObject res = new JSONObject();
        if(qingjiadanService.addQingjiadan(banjinum, codenum, simpleDateFormat.format(gc.getTime()),
                simpleDateFormat.format(gc2.getTime()), qingjiacontent, username) != null){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }

    @RequestMapping(value = "/qingjiadan/teacher/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateQingjiadanForTeacher(@RequestBody Qingjiadan req){
        JSONObject res = new JSONObject();
        if(qingjiadanService.updateQingjiadanTeacher(req.getId(), req.getShenhe(), req.getShenhecontent()) != null){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }

    @RequestMapping(value = "/qingjiadan/teacher/list/{username}", method = RequestMethod.GET)
    @ResponseBody
    public List<JSONObject> listQingjiadanByTeacher(@PathVariable String username) throws UnsupportedEncodingException {
        String teacher = new String(username.getBytes("iso8859-1"), "utf-8");

        List<JSONObject> res = new ArrayList<>();

        List<Qingjiadan> qingjiadans = qingjiadanService.listQingjiadanByUsername(teacher);
        for (Qingjiadan qingjiadan :
                qingjiadans) {
            JSONObject json = new JSONObject();
            json.put("banjiname", banjiService.getBanjiBybanjinum(qingjiadan.getBanjinum()).getBanjiname());
            json.put("banjinum", qingjiadan.getBanjinum());
            json.put("id", qingjiadan.getId());
            json.put("codenum", qingjiadan.getCodenum());
            json.put("stdname", userService.getUserByCodenum(qingjiadan.getCodenum()).getUsername());
            json.put("qjtime1", qingjiadan.getQjtime1());
            json.put("qjtime2", qingjiadan.getQjtime2());
            json.put("qingjiacontent", qingjiadan.getQingjiacontent());
            json.put("shenhe", qingjiadan.getShenhe());
            json.put("shenhecontent", qingjiadan.getShenhecontent());

            res.add(json);
        }

        return res;
    }

    @RequestMapping(value = "/qingjiadan/student/list/{codenum}", method = RequestMethod.GET)
    @ResponseBody
    public List<Qingjiadan> listQingjiadanForStudent(@PathVariable String codenum){
        return qingjiadanService.listQingjiadanByCodenum(codenum);
    }
}
