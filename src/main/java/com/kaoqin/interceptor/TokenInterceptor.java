package com.kaoqin.interceptor;

import com.kaoqin.utils.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Token处理器");
        response.setCharacterEncoding("utf-8");

        String token = request.getHeader("token");
        if(JWTUtil.verify(token)){
            return true;
        }else{
            response.sendError(401);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

//    /**
//     * 发送jwt的验证结果到客户端
//     * @author LiJun
//     * @Date 2019/9/28
//     * @Time 15:13
//     * @param response
//     * @param result
//     * @return void
//     */
//    private void returnErrorResponse(HttpServletResponse response, Object result) throws IOException {
//        OutputStream out = null;
//        try{
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/json");
//            out = response.getOutputStream();
//            out.write(JSONObject.toJSONString(result).getBytes("utf-8"));
//            out.flush();
//        } finally{
//            if(out != null){
//                out.close();
//            }
//        }
//    }


}
