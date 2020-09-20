package com.controller;

import com.mapper.UserMapper;
import com.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    UserMapper userMapper;
    private final String PREFIX = "pages/";
    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    /**
     * 返回
     * @return
     */
    @GetMapping("/back")
    public String back() {
        return "/pages/login";
    }

    /**
     * 跳转注册页
     * @return
     */

    @GetMapping("/registers")
    public String register() {
        return "register";
    }


    /**
     * 注册页
     * @return
     */

    @GetMapping("/register")
    public ModelAndView register(Users us){
        Integer add = userMapper.add(us);
        if(add>0){
            System.out.println(add.toString());
        }
        ModelAndView mv=new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    /**
     * 登陆页
     * @return
     */
    @GetMapping("/userlogin")
    public String loginPage() {
        return PREFIX+"login";
    }


    /**
     * level1页面映射
     * @param path
     * @return
     */
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PREFIX+"level1/"+path;
    }

    /**
     * level2页面映射
     * @param path
     * @return
     */
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX+"level2/"+path;
    }

    /**
     * level3页面映射
     * @param path
     * @return
     */
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PREFIX+"level3/"+path;
    }


}
