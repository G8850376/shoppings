package com.controller;

import com.mapper.DeptMapper;
import com.pojo.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 部门
 */
@Controller
public class DeptController {

    @Resource
    DeptMapper deptMapper;

    /**
     * 查所有部门
     * @return
     */
//    @GetMapping("/depts")
//    public String list(Map<String,Object> map){
//        List<Department> depts=deptMapper.getDeptByAll();
//        System.out.println(depts.size()+"=============");
//        map.put("depts",depts);
//        return "dept/list";  //classpath: /templates/ dept/list .html
//    }

    /**
     * 转到添加部门页面
     */
    @GetMapping("/dept")
    public String toAdd(){
        return "dept/add";
    }

    /**
     * 新增部门
     */
    @PostMapping("/dept")
    public String add(Department department){
        deptMapper.insertDept(department);
        return "redirect:/depts";
    }

    /**
     * 转到修改页面
     */
    @GetMapping("/dept/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Map map){
        Department department = deptMapper.getDeptById(id);
        map.put("dept",department);
        return "dept/add";
    }

    /**
     * 修改
     */
    @PutMapping("/dept")
    public String update(Department department){
        deptMapper.updateDept(department);
        return "redirect:/depts";
    }

    /**
     * 删除
     */
    @DeleteMapping("/dept/{id}")
    public String delete(@PathVariable("id") Integer id){
        deptMapper.deleteDept(id);
        return "redirect:/depts";
    }

}

