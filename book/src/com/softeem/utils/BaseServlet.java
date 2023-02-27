package com.softeem.utils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("action");
        System.out.println("methodName = " + methodName);//login,regist
        Class claxx = this.getClass();//得到UserServlet的类描述对象
        try {
            //就会得到一个方法对象.
            Method method = claxx.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);//取消访问检查
            method.invoke(this,request,response);
        } catch (Exception e) {
            System.out.println("BaseServlet的异常处理..继续抛");
            throw new RuntimeException(e);//把异常抛给Filter 过滤器
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
