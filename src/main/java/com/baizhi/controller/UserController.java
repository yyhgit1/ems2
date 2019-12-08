package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //添加
    @RequestMapping("save")
    public String save(User user, HttpServletRequest request, String number) {
        HttpSession session = request.getSession();
        //获取验证码
        String numb = (String) session.getAttribute("securityCode");
        if (number.equals(numb)) {
            User registuser = userService.findByUsername(user.getUsername());
            if (registuser != null) {
                return "redirect:/user/regist.jsp";
            } else {
                String salt = MD5Utils.getSalt();
                user.setDisturb(salt);
                user.setPassword(MD5Utils.getPassword(user.getPassword() + salt));
                userService.save(user);
                return "redirect:/user/login.jsp";
            }
        } else {
            return "redirect:/user/regist.jsp";
        }
    }

    //登录
    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (userService.findByUsername(user.getUsername()) != null) {
            User u = userService.findByUsername(user.getUsername());
            String salt = u.getDisturb();
            String pass = MD5Utils.getPassword(user.getPassword() + salt);
            if (u.getPassword().equals(pass)) {
                session.setAttribute("loginuser", user);
                return "redirect:/dept/findAll";
            } else {
                return "redirect:/user/login.jsp";
            }
        } else {
            return "redirect:/user/login.jsp";
        }
    }

    //验证码
    @RequestMapping("captchaAction")
    public String captchaAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //生成验证码随机数
        String securityCode = SecurityCode.getSecurityCode();
        HttpSession session = request.getSession();
        session.setAttribute("securityCode", securityCode);
        //绘制生成验证码图片
        BufferedImage image = SecurityImage.createImage(securityCode);
        //响应到客户端
        OutputStream out = response.getOutputStream();
        //第一个参数，指定验证码图片对象，第二个，图片的格式，第三个、指定输出流
        ImageIO.write(image, "png", out);
        //不做跳转
        return null;
    }
}
