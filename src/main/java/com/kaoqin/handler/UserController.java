package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.User;
import com.kaoqin.service.UserService;
import com.kaoqin.utils.JWTUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/regist", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject addUser(@RequestBody  User user){
        System.out.println(user);

        boolean isSuccess = false;
        try{
            Integer id = userService.addUser(user);

            if(id != null){
                isSuccess = true;
            }

            return JSONObject.parseObject("{success : " + isSuccess + "}");
        }catch (Exception e){
            JSONObject json = new JSONObject();
            json.put("success", isSuccess);
            json.put("msg", "codenum重复");
            return json;
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody User user){
        User userLogin = userService.check(user);
        JSONObject json = new JSONObject();

        if(userLogin != null){
            String token = JWTUtil.sign(userLogin.getUsername(), String.valueOf(userLogin.getId()));

            json.put("token", token);
            json.put("user", userLogin);
            json.put("success", true);

        }else {
            json.put("success", false);
        }

        log.info(json);
        return json;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateUser(@RequestBody User user){
        log.info("更新User: " + user);
        boolean isSuccess = false;
        try{
            Integer id = userService.updateUser(user);

            if(id != null){
                isSuccess = true;
            }

            return JSONObject.parseObject("{success : " + isSuccess + "}");
        }catch (Exception e){
            JSONObject json = new JSONObject();
            json.put("success", isSuccess);
            json.put("msg", "加入失败");
            return json;
        }
    }

}
