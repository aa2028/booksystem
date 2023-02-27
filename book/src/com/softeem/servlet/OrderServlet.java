package com.softeem.servlet;

import com.softeem.bean.Order;
import com.softeem.bean.User;
import com.softeem.service.Cart;
import com.softeem.service.OrderService;
import com.softeem.service.impl.OrderServiceImpl;
import com.softeem.utils.BaseServlet;
import com.softeem.utils.Page;
import com.softeem.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="OrderServlet",value = "/OrderServlet")
public class OrderServlet extends BaseServlet {


    protected void listOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl() ;
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 4);
        try {
            Page<Order> page = orderService.page(pageNo, pageSize);
            page.setUrl("OrderServlet?action=listOrder&");
            request.setAttribute("page" , page);
            request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //生成订单
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();

        Cart cart = (Cart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");

        if(user == null){
            request.setAttribute("msg" , "登录超时请重新登录!");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }

        OrderService orderService = new OrderServiceImpl() ;

            //生成订单并且返回此订单号
            String orderId = orderService.createOrder(cart, user.getId());
//            request.setAttribute("orderId",orderId);
//            request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
            //为什么选择用重定向跳转,而没有选择服务器转发?
            //为了防止表单重复提交
            session.setAttribute("orderId",orderId);
            response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
            /*
            //重定向跳转前面不要加/
            //因为它会变成 http://localhost:8080/pages/cart/checout.jsp
            response.sendRedirect("pages/cart/checkout.jsp");*/


    }
}
