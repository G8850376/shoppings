package com.controller;

import com.mapper.UserMapper;
import com.pojo.Department;
import com.pojo.Users;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import com.pojo.Commodity;
import com.repository.ComRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {

    @Resource
    ComRepository comRepository;

    @Resource
    UserMapper userMapper;


    //根据name查询商品(模糊查询)
    @GetMapping("/find")
    public ModelAndView find(String name){
        System.out.println(name);
        Commodity commodity=new Commodity();
        commodity.setId(1);
        commodity.setName("苹果");
        commodity.setPrice(1.1);
        commodity.setInventory(10);
        commodity.setComment("good");
        commodity.setType("水果");
        comRepository.index(commodity);
        System.out.println(commodity.toString());
        List<Commodity> list = comRepository.findByNameLike(name);
        ModelAndView mv= new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("/pages/level1/find");
        System.out.println(list.toString());
        return mv;
    }

//    /**
//     * 查所有部门
//     * @return
//     */
    @GetMapping("/depts")
    public String list(Map<String,Object> map){
        List<Commodity> depts=userMapper.getCom();
        System.out.println(depts.size()+"=============");
        map.put("depts",depts);
        return "/pages/level1/list";  //classpath: /templates/ dept/list .html
    }

//    @GetMapping("/lists")
//    public ModelAndView list(){
//        List<Commodity> list = userMapper.getCom();
//        ModelAndView mv= new ModelAndView();
//        mv.addObject("mylist",list);
//        mv.setViewName("/pages/level1/lists");
//        System.out.println(list.toString());
//        return mv;
//    }
//    /**
//     * 查所以商品
//     * @return
//     */
//    @GetMapping("/coms")
//    public String list(Map<String,Object> map){
//        List<Commodity> coms=userMapper.getCom();
//        System.out.println(coms.size()+"=============");
//        map.put("coms",coms);
//        return "pages/level1/list";  //classpath: /templates/ dept/list .html
//    }


}
